package coffee_and_tea.coding_exercise.data_structure.queue;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class QueueImplWithLinkedList<T> implements Queue<T>{

    private Node first = null, last = null;

    @Override
    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.value = t;

        if(oldLast != null) {
            oldLast.nextNode = last;
        } else {
            first = last;
        }
    }

    @Override
    public T dequeue() {
        T value = first.value;
        first = first.nextNode;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node current = first;

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
