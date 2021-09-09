# Coding Challenge: Count Triplets
                   
## Source of challenge: hankerrank
link: https://www.hackerrank.com/challenges/count-triplets-1/problem

### Solution discussion
For a triplet (i, j, k) where i < j < k in and array(i) * r = array(j)
and array(j) * r = array(k).

My initial solution would be a O(n**3) for array size of n. 

The improved version bring down to O(n) with auxiliary space complexity of O(n);
which uses 2 hash map, one to store the number of i where array(i) * r = array(j)
and one to store the number j where array(j) * r = array(k)

For each i, we first update j's counts, for each j met array(i) * r = array(j), 
this gives the number of possible i to build the triplet.

Then for the i, if there's already information on to build a triplet with i stored in hash map,
we can add it to the result.  