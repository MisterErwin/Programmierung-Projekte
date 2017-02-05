data List a = Nil | Cons a (List a) deriving Show

list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1 Nil))))

blist :: List Int
blist = Cons 1 (Cons 1 (Cons 0 (Cons 0 Nil)))

filterList ::(a -> Bool) -> List a -> List a
filterList _ Nil = Nil
filterList filter (Cons v n) | (filter v) = (Cons v (filterList filter n))
                             | otherwise  = filterList filter n
--b
divisibleBy :: Int -> List Int -> List Int
divisibleBy m l = filterList (\x -> mod x m == 0) l

--c
foldList :: (a->b -> b) -> b -> List a -> b
foldList f c Nil = c
foldList f c (Cons v n) = f v (foldList f c n) 

--d - Noch einfach waere die standart min fkt
listMaximum :: List Int -> Int
listMaximum l = foldList (\x y -> if x > y then x else y) minBound l 

--e
zipLists :: (a->b -> c) -> List a -> List b -> List c
zipLists f Nil _ = Nil
zipLists f _ Nil = Nil
zipLists f (Cons a an) (Cons b bn) = Cons (f a b) (zipLists f an bn)

--f
skalarprodukt :: List Int -> List Int -> Int
skalarprodukt a b = foldList(+) 0 (zipLists (*) a b)