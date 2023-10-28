package ls_10_23.ls_28_10_23;

import java.util.*;


public class Lesson24_6 {
    public static void main(String[] args) {

        Comparator<Man> comparator = new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return Integer.compare(o1.age(), o2.age());
            }
        };

        Set<Man> men = Set.of(
            new Man("John", 30),
            new Man("Jack", 25),
            new Man("Ben", 12)
        );

        Set<Man> set = new TreeSet<>(comparator.reversed());

        set.addAll(men);

        System.out.println(set);

    }
}

