package coffee_and_tea.coding_exercise.algorithms.sort;

public class ShellSort implements Sort {

    @Override
    public void sort(Comparable[] items) {

        // interval of 3 * n + 1
        int h = 1;
        while (h < items.length / 3) {
            h = 3 * h + 1;
        }

        while(h >= 1) {
            for (int i = 0; i < items.length; i++) {
                for (int j = i; j >= h && Sort.less(items, j, j - h); j -= h) {
                    Sort.exchange(items, j, j - h);
                }

            }
            h = h/3;
        }
    }
}
