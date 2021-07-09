package coffee_and_tea.coding_exercise.data_structure.priority_queue;

import coffee_and_tea.coding_exercise.algorithms.sort.Sort;

public class MaxPriorityQueueImplWithBinaryHeap<T extends Comparable<T>> implements MaxPriorityQueue<T> {

    private int capacity = 2;
    private Comparable[] heap = new Comparable[capacity];
    private int lastIdx = 0;

    @Override
    public void insert(T t) {
        if (lastIdx == capacity) {
            increaseSize();
        }

        heap[lastIdx] = t;

        swim(lastIdx++);
    }

    private void swim(int i) {
        while (parent(i) >= 0 && Sort.less(heap, parent(i), i)) {
            Sort.exchange(heap, parent(i), i);
            i = parent(i);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * (i + 1) - 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    private void increaseSize() {
        capacity *= 2;
        Comparable[] oldHeap = heap;
        heap = new Comparable[capacity];
        for (int i = 0; i < oldHeap.length; i++) {
            heap[i] = oldHeap[i];
        }
    }

    @Override
    public T delMax() {
        T value = (T) heap[0];
        heap[0] = heap[--lastIdx];
        if(lastIdx+1 < capacity)    heap[lastIdx + 1] = null;
        sink(0);
        return value;
    }

    private void sink(int i) {
        if (leftChild(i) >= lastIdx) return;
        int max = leftChild(i);
        if (rightChild(i) < lastIdx) {
            max = Sort.less(heap, leftChild(i), rightChild(i)) ? rightChild(i) : leftChild(i);
        }

        if(Sort.less(heap, i, max)) {
            Sort.exchange(heap, i, max);
        }
        sink(max);
    }

    @Override
    public boolean isEmpty() {
        return lastIdx == 0;
    }
}
