package coffee_and_tea.coding_exercise.data_structure.map;

public interface OrderMap<Key extends Comparable<Key>, Value> extends Map<Key, Value>{
    Key min();
    Key max();
    Key floor(Key key); // largest key less or equals to key
    Key ceiling(Key key); // smallest key greater or equals to key
    int rank(Key key); // number of keys less than key
    Key select(int k); // key of rank k;
    void deleteMin();
    void deleteMax();
    int size(Key lo, Key hi);
    Iterable<Key> keys(Key lo, Key hi);
}
