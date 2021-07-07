package coffee_and_tea.coding_exercise.data_structure.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class QueueImplWithArray<T> implements Queue<T> {

    private int capacity = 2;
    private Object[] values = new Object[capacity];
    private int start = 0, end = 0;

    @Override
    public void enqueue(T t) {
        if(end == capacity) {
            increaseSize();
        }
        values[end++] = t;
    }

    private void increaseSize() {
        Object[] oldValues = values;
        capacity = capacity * 2;
        values = new Object[capacity];
        for(int i = 0; i < oldValues.length; i++) {
            values[i] = oldValues[i];
        }
        System.out.println("Size increase to: " + capacity);
    }

    @Override
    public T dequeue() {
        T value = (T) values[start];
        values[start++] = null;
        if(end - start < capacity / 4) {
            reduceSize();
        }
        return value;
    }

    private void reduceSize() {
        Object[] oldValues = values;
        capacity = capacity / 2;
        values = new Object[capacity];
        for(int i = 0; i < end - start; i++) {
            values[i] = oldValues[start+i];
        }
        System.out.println("Size reduced to: " + capacity + " start: " +start+ " end: " + end);
        end = end - start;
        start = 0;

    }

    @Override
    public boolean isEmpty() {
        return start == end;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int current = start;

            @Override
            public boolean hasNext() {
                return current != end;
            }

            @Override
            public T next() {
                return (T) values[current++];
            }
        };
    }
}
