package coffee_and_tea.coding_exercise.data_structure.map;

public interface Map<Key, Value> {

    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();
}
