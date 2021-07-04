# Algorithm to determine whether 2 points in a graph are connected 
                   
## Algorithms API
An array to store N points in the graph.
A method to connect 2 points i and j in the graph: union(i, j).
A method to determine 2 points (i and j in) are connected: isConnected(i, j).

### Solution discussion

Group(k) is all nodes connected with k

#### Simple Union Find Algorithm

union(i, j) will set group(j) to all nodes in group(i)
isConnected(i, j) only need to test if i and j are in the same group

#### Quick Union Find Algorithm

Organize group(k) as a tree
union(i, j) will set root(j) to root(i)
isConnected(i, j): root(i) == root(j)

#### Improved quick union find algorithm with weight

Track weight of group with an extra array
union(i, j) append min weight of root i and j to the other root
isConnected(i, j): root(i) == root(j)

#### Further improve weighted quick union with path compression
 
Both union and isConnect function can be improved if path to root can be reduced.
Reduce the path to root when discover the root.

### Complexity

| Algorithm                                  | Complexity for union    | Complexity for isConnected |
|--------------------------------------------| ----------------------- | -------------------------- |
| Simple Union Find                          | O(N)                    | O(1)                       |
| Quick Union Find                           | O(N)                    | O(N)                       |
| Weighted Quick Union Find                  | O(logN)                 | O(logN)                    |
| Weighted Quick Union Find with Compression | O(logN) close to linear | O(logN) close to linear |