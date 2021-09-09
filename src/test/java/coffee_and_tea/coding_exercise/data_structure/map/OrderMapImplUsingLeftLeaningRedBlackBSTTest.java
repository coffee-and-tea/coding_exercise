package coffee_and_tea.coding_exercise.data_structure.map;

import coffee_and_tea.coding_exercise.algorithms.sort.Shuffle;
import coffee_and_tea.coding_exercise.algorithms.sort.ShuffleImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapImplUsingLeftLeaningRedBlackBSTTest {
    @Test
    public void testOrderMapImplPut() {
        OrderMap<String, Integer> orderMap = new OrderMapImplUsingLeftLeaningRedBlackBST();
        Integer[] alphabet = new Integer[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = i;
        }
        Shuffle shuffle = new ShuffleImpl();
        shuffle.shuffle(alphabet);

        for (int i = 0; i < 26; i++) {
            orderMap.put(Character.valueOf((char) ('A' + alphabet[i])).toString(), alphabet[i]);
        }

        orderMap.print();

    }
}