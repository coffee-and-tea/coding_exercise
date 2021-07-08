# Sorting Algorithms

Provide a function to sort Comparable items in a given array. 

## Selection Sort
Sorting by pick min item in array swap with sorting position each time, and increase sorting position each increment.
Complexity O(n**2), order of the items does not impact time of execution always need to go through all iterations.

## Insertion Sort
Sorting by insert pos i to right position between 0 and i. Complexity O(n**2), 
although if array is already sorted best case scenario take omega(n).

## Shell Sort
Sort by intervals of h, sort number by a large interval h, then reduce the interval h.
Reduce interval h to 1, then array is sorted (Insertion sort when h is 1).
Complexity of shell sort depends on serial of interval h with 3*h+1 increment is O(n**(3/2)).

## Merge Sort
Sort by splitting array into equal sub array, recursively sort sub array, and merge back. 
Auxiliary space is require of size n.

## Shuffle
Shuffle array by shuffle for each position i, randomly pick item between 0 and i, swap with item at i+1.
Helpful for testing sorts.

## Complexity

| Algorithm         | Complexity |  Stability |
|------------------ | -----------| ---------- |
| Selection sort    |  O(n**2)   | Not stable |
| Insertion sort    |  O(n**2)   | Stable     |
| Shell sort        |  O(n**(3/2)) for h = 3*h + 1 model | Not stable |
| Merge sort        |  O(n*logn) | Stable     |
