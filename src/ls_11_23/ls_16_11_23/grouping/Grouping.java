package ls_11_23.ls_16_11_23.grouping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<Man> men = List.of(
                new Man("John", 32),
                new Man("Jack", 31),
                new Man("Tom", 42),
                new Man("John", 32)
        );

        Map<Integer, List<Man>> map = men
                .stream()
                .collect(Collectors.groupingBy(m -> m.age() % 2));

        Map<Integer, Long> map1 = men
                .stream()
                .collect(Collectors.groupingBy(m -> m.age() % 2, Collectors.counting()));

        Map<String, List<Man>> map2 = men
                .stream()
                .collect(Collectors.groupingBy(m -> m.name()));

        Map<Man, List<Man>> map3 = men
                .stream()
                .collect(Collectors.groupingBy(m -> m));

        System.out.println();

        boolean isAge1 = men
                .stream()
                .allMatch(man -> man.age() > 30);

        boolean isAge2 = men
                .stream()
                .anyMatch(man -> man.age() > 30);

        System.out.println();

    }
}

record Man(String name, int age) {

}
