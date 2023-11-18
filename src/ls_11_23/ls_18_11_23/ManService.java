package ls_11_23.ls_18_11_23;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManService {
    private List<Man> men;

    public ManService() {
        men = new LinkedList<>();
    }

    /**
     * - Вывести информацию о всех людях.
     */

    public void showInfoAllMen() {
        men
                .stream()
                .forEach(System.out::println);
    }

    public void showInfoAllAddress() {
        men
                .stream()
//                .map(Man::address)
                .map(man -> man.getAddress())
//                .toList()
                .forEach(System.out::println);
    }

    /**
     * Вывести firstName, lastName, countOfChildren, когда возраст более или равно 20 и
     * *  отсортировать по firstName.
     */
    public void showConcreteInfo() {

        Comparator<Man> nameComparator = (m1, m2) -> m1.getFirstName().compareTo(m2.getFirstName());

        men
                .stream()
                .filter(man -> man.getAge() > 20)
                .sorted(nameComparator)
                .forEach(man -> System.out.println(man.getFirstName() + "\t" +
                        man.getLastName() + "\t" + man.getChildren()));
    }

    /**
     * Изменить firstName = 'John', lastName = 'Kennedi', countOfChildren = 3,
     * *  когда country == 'US' (or another country).
     */

    public void changeInfo() {
        men
                .stream()
                .filter(man -> man.getAddress().country().equals("US"))
                .peek(man -> {
                    man.setFirstName("John");
                    man.setLastName("Kennedi");
                    man.setChildren(3);
                })
                .forEach(System.out::println);
    }

    /**
     *
     */

    public void groupByChildren() {
        Map<Integer, List<Man>> map = men
                .stream()
                .collect(Collectors.groupingBy(Man::getChildren));


        map.forEach((key, value) -> System.out.println(key + "\t" + value));
    }

    /**
     * - Сгруппировать людей по городу и названию улицы и вывести количество адресов,
     *  *  где количество людей больше 4.
     */
    public void groupByCityAndStreet() {
        Map<CityStreet, Long> map = men
                .stream()
                .collect(Collectors.groupingBy(man ->
                        new CityStreet(man.getAddress().city(), man.getAddress().street()),
                        Collectors.counting()));

        map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4)
                .forEach(System.out::println);

    }
    public void groupByCityAndStreet1() {
        men
                .stream()
                .collect(Collectors.groupingBy(man ->
                        new CityStreet(man.getAddress().city(), man.getAddress().street()),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4)
                .forEach(System.out::println);

    }

}

record CityStreet(String city, String street) {

}
