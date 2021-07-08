package coffee_and_tea.coding_exercise.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {

    @Test
    public void testSelectionSort(){
        Integer[] items = new Integer[100];
        for(int i = 0; i < items.length; i++) {
            items[i] = i;
        }

        Shuffle shuffle = new ShuffleImpl();
        shuffle.shuffle(items);

        for(Integer i: items) {
            System.out.println("s: " + i);
        }

        Sort sort = new SelectionSort();
        sort.sort(items);

        int value = 0;
        for(Integer i: items) {
            System.out.println("i: " + i);
            assertEquals(i, value++);
        }
    }

}