package coffee_and_tea.coding_exercise.data_structure.map;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class MapImplUsingLinkedList<Key, Value> implements Map<Key, Value>{

    private Node first = null;
    private int size = 0;

    @Override
    public void put(Key key, Value value) {
        Node searchHead = first;
        while(searchHead != null) {
            if(searchHead.key.equals(key)){
                searchHead.value = value;
                return;
            }
            searchHead = searchHead.next;
        }
        Node oldFirst = first;
        first = new Node();
        first.key = key;
        first.value = value;
        first.next = oldFirst;
        size++;
    }

    @Override
    public Value get(Key key) {
        Node searchHead = first;
        while(searchHead != null) {
            if(searchHead.key.equals(key)){
                return searchHead.value;
            }
            searchHead = searchHead.next;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        Node currentNode = new Node();
        Node attachedHead = currentNode;
        currentNode.next = first;
        while (currentNode.next != null) {
            if(currentNode.next.key.equals(key)){
                currentNode.next = currentNode.next.next;
                size--;
                first = attachedHead.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    @Override
    public boolean contains(Key key) {
        Node searchHead = first;
        while(searchHead != null) {
            if(searchHead.key.equals(key)){
                return true;
            }
            searchHead = searchHead.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @NotNull
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    private Node current = first;
                    @Override
                    public boolean hasNext() {
                        return current != null;
                    }

                    @Override
                    public Key next() {
                        Key key = current.key;
                        current = current.next;
                        return key;
                    }
                };
            }
        };
    }

    private class Node {
        private Key key;
        private Value value;
        private Node next;
    }
}
