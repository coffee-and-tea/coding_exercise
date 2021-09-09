package coffee_and_tea.coding_exercise.algorithms.sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(Comparable[] items) {

        for (int i = 0; i < items.length - 1; i++) {
            for (int j = i + 1; j > 0 && Sort.less(items, j, j - 1); j--) {
                Sort.exchange(items, j, j - 1);
            }
        }
    }
}

