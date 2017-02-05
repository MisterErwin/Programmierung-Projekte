-- Aufgabe 2: Datenstrukturen in Haskell
data MultTree a = Daten a | Index a a [MultTree a] deriving Show

t1 :: MultTree Int
t1 = Index 3 42 [(Index 3 15 [Daten 3, Daten 11, Daten 12]), (Index 19 42 [Daten 42, Daten 23])]

--b
verzweigungsgrad :: MultTree a -> Int
verzweigungsgrad (Daten _) = 1
verzweigungsgrad (Index _ _ l) = 1 + verzweigungsgrad_ l
    where 
        verzweigungsgrad_ :: [MultTree a] -> Int
        verzweigungsgrad_ [] = 0
        verzweigungsgrad_ (x : xs) | verzweigungsgrad x > verzweigungsgrad_ xs  = verzweigungsgrad x
                                   | otherwise                                  = verzweigungsgrad_ xs
--c
-- Zwei ForEach Methoden, da wir wohl map nicht verweden duerfen
foreachI :: [a] -> (a -> b)  -> [b]
foreachI [] _ = []
foreachI (x : xs) f = (f x) : foreachI xs f

foreachA :: [a] -> (a -> [b])  -> [b]
foreachA [] _ = []
foreachA (x : xs) f = (f x) ++ foreachA xs f


add1 :: Int -> Int
add1 x = x + 1

datenListe :: (MultTree a) -> [a]
datenListe (Daten d) = [d]
datenListe (Index _ _ []) = []
datenListe (Index _ _ l) = foreachA l datenListe

datenIntervalle :: MultTree Int -> MultTree Int
datenIntervalle (Daten d) = (Daten d)
datenIntervalle (Index p1 p2 l) = (Index (getO p1 p2 (filterTree baum minL maxBound) (filterTree baum maxL minBound )) (getO p2 p1 (filterTree baum minL maxBound) (filterTree baum maxL minBound )) (foreachI l datenIntervalle))
    where
        baum = (Index p1 p2 l)
        filterTree :: (MultTree Int) -> (Int -> Int -> Bool) -> Int -> Int
        filterTree (Daten d) comp def   | (comp d def)  = d
                                        | otherwise     = def
        filterTree (Index _ _ []) _ def         = def
        filterTree (Index p1 p2 (x:xs))  f def    = filterTree x f (filterTree (Index p1 p2 xs) f def)

        getO = \p1 p2 a b -> if (p1::Int) > (p2::Int) then maxV a b else minV a b --Damit das max beim groesseren Wert steht
        minL = \a b ->  (a::Int) < (b::Int) -- a < b in "Kurzform"
        maxL = \a b ->  (a::Int) > (b::Int) -- a > b in "Kurzform"
        minV = \a b -> if minL a b then a else b -- entspricht Fkt min in Prelude
        maxV = \a b -> if maxL a b then a else b -- entspricht Fkt max in Prelude

--e
contains :: (MultTree Int) -> Int -> Bool
contains (Daten d) v                            = (d == v)
contains (Index _ _ []) _                       = False
contains (Index a b _) v    | v < a             = False
                            | v > b             = False
                            | v == a            = True
                            | v == b            = True
contains (Index a b (x:xs))  v | (contains x v) = True
                               | otherwise      = contains (Index a b xs) v  