import Prelude hiding (repeat)

second :: [Int] -> Int
second [] = 0
second (_:[]) = 0
second (_:x:xs) = x

doubleEach :: [Int] -> [Int]
doubleEach [] = []
doubleEach (x:xs) = x * 2 : (doubleEach xs)

repeat :: Int -> Int -> [Int]
repeat x n | n > 0 = (x : repeat x (n-1))
           | otherwise = []
