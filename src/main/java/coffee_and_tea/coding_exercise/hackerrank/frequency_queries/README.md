# Coding Challenge: Frequency Queries
                   
## Source of challenge: hankerrank
link: https://www.hackerrank.com/challenges/frequency-queries/problem

### Solution discussion
Creating 2 hash map: one to track frequency, key is the input, value is the count of the input;
Another to track frequency count: key is the count, value is number of input appeared.
Overall complexity for add input is O(1), remove one is also O(1), query is also O(1).