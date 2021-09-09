package coffee_and_tea.coding_exercise.algorithms.sort;

public class QuickSort implements Sort {

    @Override
    public void sort(Comparable[] items) {
        Shuffle shuffle = new ShuffleImpl();
        shuffle.shuffle(items);

        sort3WayPartition(items, 0, items.length - 1);
    }

    /* 3 way partition considering duplicate entries */
    private void sort3WayPartition(Comparable[] items, int lo, int hi) {
        if(hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = items[lo];
        int i = lo;
        while(i <= gt) {
            int cmp = items[i].compareTo(v);
            if(cmp < 0) Sort.exchange(items, lt++, i++);
            else if (cmp > 0) Sort.exchange(items, i, gt--);
            else i++;
        }

        sort(items, lo, lt - 1);
        sort(items, gt + 1, hi);
    }

    /* traditional quicksort */
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
