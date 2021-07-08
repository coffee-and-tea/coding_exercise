package coffee_and_tea.coding_exercise.algorithms.sort;

public class QuickSort implements Sort {

    @Override
    public void sort(Comparable[] items) {
        Shuffle shuffle = new ShuffleImpl();
        shuffle.shuffle(items);

        sort(items, 0, items.length - 1);
    }

    private void sort(Comparable[] items, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(items, lo, hi);
        sort(items, lo, j-1);
        sort(items, j+1, hi);
    }

    private static int partition(Comparable[] items, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while(Sort.less(items, ++i, lo)){
                if(i == hi) break;
            }

            while(Sort.less(items, lo, --j)){
                if(j == lo) break;
            }

            if(i >= j) break;

            Sort.exchange(items, i, j);
        }

        Sort.exchange(items, lo, j);
        return j;
    }
}
