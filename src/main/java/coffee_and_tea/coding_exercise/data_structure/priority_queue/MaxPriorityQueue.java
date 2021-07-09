package coffee_and_tea.coding_exercise.data_structure.priority_queue;

public interface MaxPriorityQueue<T extends Comparable<T>> {

    void insert(T t);
    T delMax();
    boolean isEmpty();
}
