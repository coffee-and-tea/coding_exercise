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

### 2-3 tree
Node can have 2 values, and child organized as less, middle and greater.
Red-black tree is a version of 2-3 tree.

### B-tree
Like 2-3 tree but have a very large number of values stored in a node.

### Hash with Separate chaining
Hash the key and use linked list to chain same hash values.
Use a fix size table to store keys, size is smaller than number of keys.

### Hash with linear probing
Hash the key, store in table, where table size is much larger than number of keys.
Same hash just look for next empty position to put key.

## Complexity of Operations

| Implementation | |     worst-case  | | |       average case        | | 
| -------------- | ------ | ------ | ------ | ------ | ------ | ------ |
|                                   | Search | Insert | Delete | Search | Insert | Delete |
| Linked list(unordered list)       | N      | N      | N      |  N/2   |  N     | N/2    |
| Binary search tree(ordered list)  | lgN    | N      | N      |  lgN   |  N/2   | N/2    |
| 2-3 tree                          | ~lgN   | ~lgN   | ~lgN   | ~lgN   | ~lgN   | ~lgN   |
| Hash with Separate chaining       | lgN    | lgN    | lgN    |  3-5   |  3-5   |  3-5   | 
| Hash with linear probe            | lgN    | lgN    | lgN    |  3-5   |  3-5   |  3-5   | 