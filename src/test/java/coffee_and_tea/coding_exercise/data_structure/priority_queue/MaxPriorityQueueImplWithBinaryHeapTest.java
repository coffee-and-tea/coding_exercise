package coffee_and_tea.coding_exercise.data_structure.priority_queue;

import org.junit.jupiter.api.Test;

class MaxPriorityQueueImplTest {

    @Test
    public void testMaxPriorityQueueImplWithBinaryHeap(){
        MaxPriorityQueue<String> maxPriorityQueue = new MaxPriorityQueueImplWithBinaryHeap<>();

        maxPriorityQueue.insert("A");
        maxPriorityQueue.insert("B");
        maxPriorityQueue.insert("Z");
        maxPriorityQueue.insert("D");
        System.out.println(maxPriorityQueue.delMax());
        maxPriorityQueue.insert("H");
        maxPriorityQueue.insert("M");
        maxPriorityQueue.insert("N");
        while(!maxPriorityQueue.isEmpty()){
            System.out.println(maxPriorityQueue.delMax());
        }
    }

    @Test
    public void testMaxPriorityQueueImplWithBinaryHeap2(){
        MaxPriorityQueue<String> maxPriorityQueue = new MaxPriorityQueueImplWithBinaryHeap<>();

        maxPriorityQueue.insert("A");
        maxPriorityQueue.insert("B");
        maxPriorityQueue.insert("Z");
        maxPriorityQueue.insert("D");
        System.out.println(maxPriorityQueue.delMax());
        maxPriorityQueue.insert("H");
        maxPriorityQueue.insert("M");
        maxPriorityQueue.insert("N");
        maxPriorityQueue.insert("B");
        maxPriorityQueue.insert("C");
        maxPriorityQueue.insert("D");
        maxPriorityQueue.insert("O");
        maxPriorityQueue.insert("N");
        while(!maxPriorityQueue.isEmpty()){
            System.out.println(maxPriorityQueue.delMax());
        }
    }

}