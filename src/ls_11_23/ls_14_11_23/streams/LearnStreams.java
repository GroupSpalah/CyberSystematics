package ls_11_23.ls_14_11_23.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LearnStreams {
    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human(32, "John"),
                new Human(25, "Ben"),
                new Human(19, "Tom"),
                new Human(10, "Ann"),
                new Human(20, "Katerina"),
                new Human(18, "Galyna")
        );

      /*  for (Human human : humans) {
            if (human.age() > 20) {
                System.out.println(human);
            }
        }*/

        Predicate<Human> predicate = human -> human.age() > 20;

        Consumer<Human> consumer = human -> System.out.println(human);

/*        humans
                .stream()//Stream<Human> - stream all humans
                .filter(predicate)//filtered Stream<Human>
                .forEach(consumer);//print in console*/

        Function<Human, Child> function = human -> new Child(human.age(), human.name());

       /* humans
                .stream()//Stream<Human> - stream all humans
                .map(function)//Stream<Child> - stream all children
                .forEach(child -> System.out.println(child)); */

        /*humans
                .stream()//Stream<Human> - stream all humans
                .filter(human -> human.age() > 20)//filtered Stream<Human>
                .map(function)//Stream<Child> - stream all children
                .forEach(child -> System.out.println(child));*/

        int sum = humans
                .stream()//Stream<Human> - stream all humans
                .filter(human -> human.age() > 20)//filtered Stream<Human>
                .mapToInt(h -> h.age())//Stream<Integer> - stream all ages
                .sum();

        System.out.println(sum);

        double avg = humans
                .stream()//Stream<Human> - stream all humans
                .filter(human -> human.age() > 20)//filtered Stream<Human>
                .mapToInt(h -> h.age())//Stream<Integer> - stream all ages
                .average()
                .getAsDouble();


    }
}

record Human(int age, String name) {

}
record Child(int age, String name) {

}
