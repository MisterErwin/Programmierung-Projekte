drop_mult :: Int -> [Int] -> [Int]
drop_mult x xs = filter (\y -> mod y x /= 0) xs

from :: Int -> [Int]
from x = x : from (x+1)

dropall :: [Int] -> [Int]
dropall (x:xs) = x : dropall (drop_mult x xs)

primes :: [Int]
primes = dropall (from 2)


isGood :: [Int]
isGood = isGood_ 1 where
    isGood_ :: Int -> [Int]
    isGood_ n | (primes!!n * primes!!n) > primes!!(n-1) * primes!!(n+1) = (primes !!n) : isGood_ (n+1)
              | otherwise = isGood_(n+1)
