package coffee_and_tea.coding_exercise.data_structure.map;

import org.junit.jupiter.api.Test;

class MapImplUsingLinkedListTest {

    @Test
    public void testMap(){
        Map<String, Integer> map = new MapImplUsingLinkedList<>();
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
        System.out.println("===============================================");
        for(int i = Character.valueOf('A'); i <= Character.valueOf('Z'); i++) {
            map.put(Character.toString((char)i), i);
        }
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
        System.out.println("===============================================");
        map.delete("Z");
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("===============================================");
        map.delete("X");
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("===============================================");
        map.delete("Y");
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("===============================================");
        map.delete("A");
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("===============================================");
        map.delete("B");
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("===============================================");
        map.put("B", 12);
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("===============================================");
        map.put("B", 13);
        System.out.println("Map size: " + map.size());
        for(String key : map.keys()){
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        System.out.println("Map contains A: " + map.contains("A"));
        System.out.println("Map contains B: " + map.contains("B"));
        System.out.println("Map contains Z: " + map.contains("Z"));
    }

}