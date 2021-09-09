package coffee_and_tea.coding_exercise.data_structure.map;

import coffee_and_tea.coding_exercise.algorithms.sort.Shuffle;
import coffee_and_tea.coding_exercise.algorithms.sort.ShuffleImpl;
import org.junit.jupiter.api.Test;

class OrderMapImplUsingBinarySearchTreeTest {

    @Test
    public void testOrderMapImplPut() {
        OrderMap<String, Integer> orderMap = new OrderMapImplUsingBinarySearchTree();
        Integer [] alphabet = new Integer[26];
        for(int i = 0; i < 26; i++){
            alphabet[i] = i;
        }
        Shuffle shuffle = new ShuffleImpl();
        shuffle.shuffle(alphabet);

        for(int i = 0; i < 26; i++){
            orderMap.put(Character.valueOf((char)('A'+alphabet[i])).toString(), alphabet[i]);
        }

        orderMap.print();

        System.out.println(orderMap.size());
        System.out.println("Size A to Z: " + orderMap.size("A","Z"));
        System.out.println("Size B to Y: " + orderMap.size("B","Y"));
        System.out.println("Size C to X: " + orderMap.size("C","X"));
        System.out.println("Size D to E: " + orderMap.size("D","E"));
        System.out.println("Size D to D: " + orderMap.size("D","D"));
        System.out.println("Get A: " + orderMap.get("A"));
        System.out.println("Get Z: " + orderMap.get("Z"));
        System.out.println("Get H: " + orderMap.get("H"));
        System.out.println("Min: " + orderMap.min());
        System.out.println("Max: " + orderMap.max());
        System.out.println("Contains A: " + orderMap.contains("A"));
        System.out.println("Contains O: " + orderMap.contains("O"));
        System.out.println("Contains =: " + orderMap.contains("="));
        System.out.println("Is empty: " + orderMap.isEmpty());

        System.out.println("Floor a: " + orderMap.floor("a"));
        System.out.println("Ceiling a: " + orderMap.ceiling("a"));
        System.out.println("Ceiling A-1: " + orderMap.ceiling(Character.valueOf((char)('A'-1)).toString()));
        System.out.println("Rank A: " + orderMap.rank( "A"));
        System.out.println("Rank Z: " + orderMap.rank( "Z"));
        System.out.println("Rank H: " + orderMap.rank( "H"));
        System.out.println("Select 7:" + orderMap.select(7));
        System.out.println("Select 0:" + orderMap.select(0));
        System.out.println("Select 25:" + orderMap.select(25));

        orderMap.deleteMin();
        orderMap.deleteMax();
        orderMap.print();
        System.out.println(orderMap.get("A"));
        System.out.println(orderMap.get("Z"));
    }

}