# Basic data structure Stack and Queue
                   
## Data Structure API
### Stack
Provides push() and pop() function, push add an item, pop retrieve last item added, LIFO.
isEmpty() determines if there's any item left in Stack.
Provides iterator interface to iterate over items.

### Queue
Provides enqueue() and dequeue function, enqueue add an item, dequeue retrieve the first item in queue, FIFO.
isEmpty() determines if there's any item left in Stack.
Provides iterator interface to iterate over items.

## Implementation

### Linked List Implementation

Both stack and queue with linked list implementation will have constant time for adding/retrieving items.
Although additional overhead for storing data with pointers.

### Array Implementation

Both stack and queue with array implementation will have O(N) for adding and retrieving item.
Potential use less space without pointer and Object overhead. It's more expensive in time to increase/reduce in size.

## Complexity

| Data structure                             | Complexity for adding   | Complexity for retrieving  |
|--------------------------------------------| ----------------------- | -------------------------- |
| Stack with Linked List Implementation      | O(1)                    | O(1)                       |
| Stack with Array Implementation            | O(N)                    | O(N)                       |
| Queue with Linked List Implementation      | O(1)                    | O(1)                       |
| Queue with Array Implementation            | O(N)                    | O(N)                       |