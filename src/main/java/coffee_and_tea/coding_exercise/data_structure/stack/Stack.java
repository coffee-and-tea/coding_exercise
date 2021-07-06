package coffee_and_tea.coding_exercise.data_structure.stack;

interface Stack<T> extends Iterable<T> {

    void push(T t);
    T pop();
    boolean isEmpty();
}
