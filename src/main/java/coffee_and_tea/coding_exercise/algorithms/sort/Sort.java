package coffee_and_tea.coding_exercise.algorithms.sort;

public interface Sort {
    void sort(Comparable[] items);

    static boolean less(Comparable[] items, int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    static void exchange(Comparable[] items, int i, int j) {
        Comparable swap = items[i];
        items[i] = items[j];
        items[j] = swap;
    }
}
