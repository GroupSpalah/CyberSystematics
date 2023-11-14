package ls_11_23.ls_14_11_23.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReferenceOnMethod {
    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human(32, "John"),
                new Human(25, "Ben"),
                new Human(19, "Tom"),
                new Human(10, "Ann"),
                new Human(20, "Katerina"),
                new Human(18, "Galyna")
        );

//        Function<Human, Child> function = human -> new Child(human.age(), human.name());
//        Function<Human, Worker> function = human -> new Worker(human);
        Function<Human, Worker> function = Worker::new;

        humans
                .stream()//Stream<Human> - stream all humans
                .filter(human -> human.age() > 20)//filtered Stream<Human>
                .map(function)//Stream<Worker> - stream all workers
                .forEach(System.out::println);

    }
}

record Worker(String name, int age) {
    public Worker(Human human) {
        this(human.name(), human.age());
    }
}

