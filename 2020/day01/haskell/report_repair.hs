import System.IO  
main = do  
    input <- readFile "input.txt"
    print (findTwoNumbers (strToIntList input))
    print (findThreeNumbers (strToIntList input))

strToIntList :: String -> [Int]
strToIntList xs = [read x :: Int | x <- lines xs]

--part1
findTwoNumbers :: [Int] -> Int
findTwoNumbers [] = error "Empty list"
findTwoNumbers [x] = -1
findTwoNumbers (x:xs) = if result + x == 2020 then value else findTwoNumbers xs
                    where result = findTwoNumbersAux x xs
                          value = result * x

findTwoNumbersAux :: Int -> [Int] -> Int
findTwoNumbersAux _ [] = error "Empty list"
findTwoNumbersAux num [x] = if num + x == 2020 then x else -1
findTwoNumbersAux num (x:xs) = if num + x == 2020 then x else findTwoNumbersAux num xs

-- part 2
findThreeNumbers :: [Int] -> Int
findThreeNumbers [] = error "Empty list"
findThreeNumbers [x] = -1
findThreeNumbers [x,y] = -1
findThreeNumbers (x:xs) = if x + fst result + snd result == 2020 then value else findThreeNumbers xs
                    where result = findThreeNumbersAux x xs
                          value = x * fst result * snd result

findThreeNumbersAux :: Int -> [Int] -> (Int, Int)
findThreeNumbersAux _ [] = error "Empty list"
findThreeNumbersAux a [x] = (-1, -1)
findThreeNumbersAux a (x:xs) = if a + x + c == 2020 then (x, c) else findThreeNumbersAux a xs
                            where c = findThreeNumbersAux2 a x xs


findThreeNumbersAux2 :: Int -> Int -> [Int] -> Int
findThreeNumbersAux2 _  _ [] = error "Empty list"
findThreeNumbersAux2 a b [x] = if a + b + x == 2020 then x else -1
findThreeNumbersAux2 a b (x:xs) = if a + b + x == 2020 then x else findThreeNumbersAux2 a b xs
