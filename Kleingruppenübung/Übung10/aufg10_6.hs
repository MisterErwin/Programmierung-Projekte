-- a)
isEven :: Int -> Bool
isEven 0 = True
isEven 1 = False
isEven x = isEven (x-2)

-- b)
arithSeries :: Int -> Int -> Int
arithSeries x d | x > 0     = x + arithSeries (x - d) d
                | otherwise = 0

-- c)
-- Checks if a list is sorted
isSorted :: [Int] -> Bool
isSorted []     = True
isSorted (x:[]) = True
isSorted (x:xs) | x <= next(xs) = isSorted(xs)
                | otherwise     = False
-- Helper function for isSorted
next :: [Int] -> Int
next (x:xs) = x

-- d)
interval :: Int -> Int -> [Int]
interval a b | a /= b     = (a:interval (a+1) b)
             | otherwise  = [a]

-- e)
--Das ganze liesse sich verbessern, wenn man Teillisten wegwerfen wuerde
--Das 3. Elem von [100,99,98] kostet im Moment viel... sehr viel..
--Vom letzten Elem. von Listen mit seehr großen Werten rede ich mal nicht
selectKsmallest :: Int -> [Int] -> Int
selectKsmallest k xs = selectKsmallestH k xs 0
    where   selectKsmallestH :: Int -> [Int] -> Int -> Int
            selectKsmallestH k xs x | length(firstListElem( splitAtX x xs)) == k = biggestListElem (firstListElem (splitAtX x xs)) 
                                    | length(firstListElem( splitAtX x xs)) > k  = selectKsmallestH k xs (x-1) 
                                    | length(firstListElem( splitAtX x xs)) < k  = selectKsmallestH k xs (x+1) 
            firstListElem :: [_x] -> _x --Wildcards und Pattern Matching to the rescue!
            firstListElem [x] = x
            firstListElem (x:_) = x
            lastListElem :: [_x] -> _x 
            lastListElem [x] = x
            lastListElem (x:xs) = lastListElem xs
            biggestListElem :: [Int] -> Int --Gibt das groesste Elem einer Liste zurueck
            biggestListElem [x] = x
            biggestListElem (x:y:[])    = if x>y then x else y
            biggestListElem (x:y:xs) | x > y = biggestListElem (x:xs)
                                     | True  = biggestListElem (y:xs)

            --Teilt [Int] in [[Int <gleich x],[Int > x]] auf
            splitAtX :: Int -> [Int] -> [[Int]]
            splitAtX x xs = splitAt_ x xs [[],[]] 

            --Teilt auf, nur mit Liste zum anhaengen
            splitAt_ :: Int -> [Int] -> [[Int]] -> [[Int]]
            splitAt_ x [] ex = ex
            splitAt_ x (f:fs) ex    | f <= x = splitAt_ x fs (addToList [f] [] ex)
                                    | otherwise = splitAt_ x fs (addToList [] [f] ex)

            --Fuegt a zur 1. Liste und b zur 2. Liste des 3. Params hinzu
            addToList :: [Int] -> [Int] -> [[Int]] -> [[Int]]
            addToList a b [r,l] = [r++a,l++b]




