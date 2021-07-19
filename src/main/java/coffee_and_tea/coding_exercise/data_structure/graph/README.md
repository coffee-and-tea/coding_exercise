# Basic data structure Undirected Graph

## Undirected Graph API
Constructor with number of vertex. Provide function to add edge, and return adjacent vertexes of a vertex.
Also number of vertex and edges in the graph.

### Set of edge representation
Store list of edges, query list to figure out what vertexes are connected.

### Adjacency-matrix representation
Maintenance a matrix size of V*V, if there's edge in for vertex v and w then adj[v][w] = adj[w][v] = true.

### Adjacency-list representation
Maintenance an array of lists, for each vertex keep a list of all connected vertexes.


## Complexity

| Data structure     | Space   | Add Edge  | Edge between v and w? | Iterate over vertices adjacent to v? |
|------------------- | ------- | --------- | --------------------- | ------------------------------------   |
| List of edge       | E       | 1         | E                     | E                                    |
| Adjacency-matrix   | V**2    | 1         | 1                     | V                                    |
| Adjacency-list     | E+V     | 1         | degree(v)             | degree(v)                            |