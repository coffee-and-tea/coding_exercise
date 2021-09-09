package coffee_and_tea.coding_exercise.algorithms.sort;

import java.util.Random;

public class ShuffleImpl implements Shuffle{

    @Override
    public void shuffle(Comparable[] items) {

        Random random = new Random();
        for(int i = 0; i < items.length; i++){
            int randomPos = random.nextInt(i+1);
            Sort.exchange(items, i, randomPos);
        }
    }
}
