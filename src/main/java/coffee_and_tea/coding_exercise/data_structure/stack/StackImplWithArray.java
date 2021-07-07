package coffee_and_tea.coding_exercise.data_structure.stack;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class StackImplWithArray<T> implements Stack<T> {

    private int capacity = 2;
    private Object [] values = new Object[capacity];
    private int lastPos = 0;

    @Override
    public void push(T t) {
        if(lastPos == capacity) {
            increaseSize();
        }
        values[lastPos++] = t;
    }

    private void increaseSize() {
        Object [] oldValues = values;
        capacity = capacity * 2;
        values = new Object[capacity];
        for(int i = 0; i < oldValues.length; i++ ){
            values[i] = oldValues[i];
        }
        System.out.println("Size increased to: " + capacity);
    }

    @Override
    public T pop() {
        T value = (T) values[--lastPos];
        values[lastPos] = null;
        if(lastPos < capacity / 4) {
            reduceSize();
        }
        return value;
    }

    private void reduceSize() {
        Object[] oldValues = values;
        capacity = capacity / 2;
        values = new Object[capacity];
        for(int i = 0; i < lastPos; i++) {
            values[i] = oldValues[i];
        }
        System.out.println("Size reduced to: " + capacity);
    }

    @Override
    public boolean isEmpty() {
        return lastPos == 0;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int current = lastPos;

            @Override
            public boolean hasNext() {
                return current != 0;
            }

            @Override
            public T next() {
                return (T) values[--current];
            }
        };
    }
}
