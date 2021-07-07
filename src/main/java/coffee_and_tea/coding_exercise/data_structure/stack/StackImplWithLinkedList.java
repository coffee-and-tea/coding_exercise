package coffee_and_tea.coding_exercise.data_structure.stack;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class StackImplWithLinkedList<T> implements Stack<T>{

    private Node last = null;

    @Override
    public void push(T t) {
        Node oldLast = last;
        last = new Node();
        last.value = t;
        last.nextNode = oldLast;
    }

    @Override
    public T pop() {
        T value = last.value;
        last = last.nextNode;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private Node current = last;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.nextNode;
                return value;
            }
        };
    }


    private class Node {
        private T value;
        private Node nextNode;
    }
}
