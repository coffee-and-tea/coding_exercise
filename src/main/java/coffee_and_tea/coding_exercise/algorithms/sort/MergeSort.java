package coffee_and_tea.coding_exercise.algorithms.sort;

public class MergeSort implements Sort {

    @Override
    public void sort(Comparable[] items) {
        Comparable[] aux = new Comparable[items.length];
        sort(items, aux, 0, items.length - 1);
    }

    private void sort(Comparable[] items, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + ((hi - lo) / 2);
        sort(items, aux, lo, mid);
        sort(items, aux, mid + 1, hi);
        if(!Sort.less(items, mid+1, mid)) return;
        merge(items, aux, lo, mid, hi);
    }

    private void merge(Comparable[] items, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = items[k];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                items[k] = aux[j++];
            } else if (j > hi) {
                items[k] = aux[i++];
            } else if (Sort.less(aux, j, i)) {
                items[k] = aux[j++];
            } else {
                items[k] = aux[i++];
            }
        }
    }


}
