package coffee_and_tea.coding_exercise.data_structure.priority_queue;

import coffee_and_tea.coding_exercise.algorithms.sort.Shuffle;
import coffee_and_tea.coding_exercise.algorithms.sort.ShuffleImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxPriorityQueueImplTest {

    @Test
    public void testMaxPriorityQueueImplWithBinaryHeap() {
        MaxPriorityQueue<String> maxPriorityQueue = new MaxPriorityQueueImplWithBinaryHeap<>();

        maxPriorityQueue.insert("A");
        maxPriorityQueue.insert("B");
        maxPriorityQueue.insert("Z");
        maxPriorityQueue.insert("D");
        System.out.println(maxPriorityQueue.delMax());
        maxPriorityQueue.insert("H");
        maxPriorityQueue.insert("M");
        maxPriorityQueue.insert("N");
        while (!maxPriorityQueue.isEmpty()) {
            System.out.println(maxPriorityQueue.delMax());
        }
    }

    @Test
    public void testMaxPriorityQueueImplWithBinaryHeap2() {

        Integer[] items = new Integer[1000];
        MaxPriorityQueue<Integer> maxPriorityQueue = new MaxPriorityQueueImplWithBinaryHeap<>();

        for (int i = 0; i < 1000; i++) {
            items[i] = i;
        }
        Shuffle shuffle = new ShuffleImpl();
        shuffle.shuffle(items);

        for (int i = 0; i < 1000; i++) {
            maxPriorityQueue.insert(i);
        }
        int i = 1000;
        while (!maxPriorityQueue.isEmpty()) {
            Integer value = maxPriorityQueue.delMax();
            assertEquals(value, --i);
            System.out.println(value);
        }
    }

}