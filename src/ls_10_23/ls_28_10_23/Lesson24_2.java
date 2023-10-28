package ls_10_23.ls_28_10_23;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a map of food keys and their topping values,
 * modify and return the map as follows: if the key "ice cream"
 * has a value, set that as the value
 * for the key "yogurt" also. If the key "spinach" has a value,
 * change that value to "nuts".
 */

public class Lesson24_2 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("ice cream", "Hello");
        map.put("spinach", "World");

        if (map.containsKey("ice cream")) {
            String valueA = map.get("ice cream");

            if (Objects.nonNull(valueA)) {
                map.put("yogurt", valueA);
            }
        }

        if (map.containsKey("spinach")) {
            String valueS = map.get("spinach");

            if (Objects.nonNull(valueS)) {
                map.put("spinach", "nuts");
            }
        }

        System.out.println(map);
    }
}
