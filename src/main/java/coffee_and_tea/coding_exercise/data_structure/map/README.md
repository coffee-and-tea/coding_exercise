#  Data structure Map

Map provides API to associate key and value pair.
Operations provide put a key/value pair, get by key, delete by key, check if key is in map,
size of map, and whether map is empty and provides a list of keys to iterate.

Additional operations can be provided if key can be ordered (Comparable)
## Implementation

### Linked list implementation
Simple implementation to use linked list to store key/value pairs.

### Binary Search Tree implementation
Using binary search tree, an order map can be implemented.


## Complexity of Operations

| Implementation | |     worst-case  | | |       average case        | | 
| -------------- | ------ | ------ | ------ | ------ | ------ | ------ |
|                                   | Search | Insert | Delete | Search | Insert | Delete |
| Linked list(unordered list)       | N      | N      | N      |  N/2   |  N     | N/2    |
| Binary search tree(ordered list)  | lgN    | N      | N      |  lgN   |  N/2   | N/2    |
|
