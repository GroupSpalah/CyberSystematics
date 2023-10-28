package ls_10_23.ls_28_10_23;

import java.util.Map;
import java.util.TreeMap;

public class Lesson24_7 {
    public static void main(String[] args) {

        Map<Integer, Man> men = Map.of(
                1, new Man("John", 30),
                7, new Man("Jack", 25),
                2, new Man("Ben", 12)
        );

        Map<Integer, Man> map = new TreeMap<>(men);

        System.out.println(map);

    }
}
