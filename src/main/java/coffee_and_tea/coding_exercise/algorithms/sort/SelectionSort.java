package coffee_and_tea.coding_exercise.algorithms.sort;

public class SelectionSort implements Sort {

    @Override
    public void sort(Comparable[] items) {
        for(int i = 0; i < items.length; i++){
            int minIdx = i;
            for(int j = i; j < items.length; j++) {
                if(Sort.less(items, j, minIdx)){
                    minIdx = j;
                }
            }
            Sort.exchange(items, i, minIdx);
        }
    }
}
