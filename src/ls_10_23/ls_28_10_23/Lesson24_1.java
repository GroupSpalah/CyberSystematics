package ls_10_23.ls_28_10_23;

import java.util.HashMap;
import java.util.Map;

/**
 * Modify and return the given map as follows: if the key "a"
 * has a value, set the key "b" to have that same value.
 * In all cases remove the key "c", leaving the rest of the map unchanged.
 */

public class Lesson24_1 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("a", "Hello");
        map.put("c", "World");

        if (map.containsKey("a")) {
            String valueA = map.get("a");

            map.put("b", valueA);
        }

        map.remove("c");

        System.out.println(map);
    }
}
