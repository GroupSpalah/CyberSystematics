package ls_11_23.ls_18_11_23.pattern.creational.singleton;

import java.util.Objects;

public class Singleton {
    private String name;
    private int age;

    private static Singleton obj;

    private Singleton(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Singleton getInstance(String name, int age) {
        if (Objects.isNull(obj)) {
            obj = new Singleton(name, age);
        }

        return obj;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class TestSingleton {
    public static void main(String[] args) {
        Singleton john = Singleton.getInstance("John", 23);

        System.out.println(john);

        Singleton jack = Singleton.getInstance("Jack", 35);

        System.out.println(jack);
    }
}
