package coffee_and_tea.coding_exercise.data_structure.map;

public class MapUsingSeparateChainingHash<Key, Value> implements Map<Key, Value>{

    private int M = 5;
    private Node[] st = new Node[M];

    @Override
    public void put(Key key, Value value) {
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next) {
            if(key.equals(x.key)) {x.value = value; return;}
        }
        st[i] = new Node(key, value, st[i]);
    }

    @Override
    public Value get(Key key) {
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next) {
            if(key.equals(x.key)) return (Value)x.value;
        }
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next) {
            if(key.equals(x.key)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i < M; i++) {
            if(st[i] != null) return false;
        }
        return true;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO
        return null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff % M);
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
