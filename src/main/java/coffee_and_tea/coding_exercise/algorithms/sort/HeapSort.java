package coffee_and_tea.coding_exercise.algorithms.sort;

import coffee_and_tea.coding_exercise.data_structure.priority_queue.MaxPriorityQueueImplWithBinaryHeap;

import java.util.Arrays;

public class HeapSort implements Sort{

    @Override
    public void sort(Comparable[] items) {

       for(int i = items.length - 1; i >= 0; i--){
           sink(items, i, items.length-1);
       }

        for(int i = items.length - 1; i >= 0; i--){
            Sort.exchange(items, i, 0);
            sink(items, 0, i);
        }

    }

    private void sink(Comparable[] items, int i, int end){
        if (leftChild(i) >= end) return;
        int max = leftChild(i);
        if (rightChild(i) < end) {
            max = Sort.less(items, leftChild(i), rightChild(i)) ? rightChild(i) : leftChild(i);
        }

        if(Sort.less(items, i, max)) {
            Sort.exchange(items, i, max);
            sink(items, max, end);
        }
    }

    private static int leftChild(int i) {
        return 2 * (i + 1) - 1;
    }

    private static int rightChild(int i) {
        return 2 * (i + 1);
    }
}
