package coffee_and_tea.coding_exercise.data_structure.map;

import org.junit.jupiter.api.Test;

class MapUsingSeparateChainingHashTest {
    @Test
    public void testMap(){
        Map<String, Integer> map = new MapUsingSeparateChainingHash<>();
        System.out.println("Map size: " + map.size());

        for(int i = Character.valueOf('A'); i <= Character.valueOf('Z'); i++) {
            map.put(Character.toString((char)i), i);
        }

        map.put("B", 12);

        System.out.println("===============================================");
        map.put("B", 13);

        System.out.println("Map contains A: " + map.contains("A") + map.get("A"));
        System.out.println("Map contains B: " + map.contains("B") + map.get("B"));
        System.out.println("Map contains Z: " + map.contains("Z") + map.get("Z"));
    }
}