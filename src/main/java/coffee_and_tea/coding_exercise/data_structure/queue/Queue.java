package coffee_and_tea.coding_exercise.data_structure.queue;

interface Queue<T> extends Iterable<T> {

    void enqueue(T t);
    T dequeue();
    boolean isEmpty();
}
