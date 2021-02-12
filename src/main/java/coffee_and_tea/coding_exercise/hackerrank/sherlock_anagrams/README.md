# Coding Challenge: Sherlock and Anagrams
                   
## Source of challenge: hankerrank
link: https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

### Solution discussion
Assuming a string length of n, we need to check from 1 to n - 1 of anagrams of substrings.
For substring length of i, need to check anagrams among substring from (1, 1+i) ... (m, m+i) ...
note: above substring both ends are inclusive. 

The way to check anagram is to sort the string's characters, then compare.
Sorting one substring is complexity of O(mlogm) m is size of substring.

There's n-m of substrings to sort for substrings length of m, O((n-m)*m*logm)
Needs to perform check for size m from 1 to n - 1 which is O(n*1*log1)...O(1*(n-1)*log(n-1))
Overall complexity: (n*n*nlogn)

Another note, saw an algorithm using sum hash of each character in string to determine anagram, smarter way to do it.

