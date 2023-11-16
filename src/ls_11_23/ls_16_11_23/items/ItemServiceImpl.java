package ls_11_23.ls_16_11_23.items;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {

    private List<Item> items;

    public ItemServiceImpl() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * 1) Одного производителя, хрупкие
     */
    @Override
    public List<Item> findAllByProducerAndCrush(Producer producer) {

        Predicate<Item> producerPredicate = item -> item.producer().equals(producer);
        Predicate<Item> crushPredicate = Item::isCrush;

        Predicate<Item> predicate = producerPredicate.and(crushPredicate);

       /* Predicate<Item> itemPredicate =
                item -> item.producer().equals(producer) && item.isCrush();*/
        List<Item> list = items
                .stream()//Stream<Item>
                .filter(predicate)//Stream<Item>
//                .toList();
                .collect(Collectors.toList());

        return list;
    }

    /**
     * 2) Товары, произведенные между двумя датами
     */
    @Override
    public List<Item> findAllByBetweenTwoDates(LocalDate from, LocalDate to) {//11, 20

        List<Item> list = items
                .stream()//
                .filter(item -> {
                    LocalDate date = item.date();//item.getDate();

                    boolean between = date.isAfter(from) && date.isBefore(to);
                    return between;
                })
                .toList();
        return list;
    }

    /**
     * price = 15;
     *
     * from = 10, to = 20
     */
// * 3) Товары, цена которых лежит в определенном промежутке.

    @Override
    public List<Item> findAllByBetweenPrices(float priceFrom, float priceTo) {

        List<Item> list = items
                .stream()
                .filter(item -> {
                    float price = item.price();//item price
                    boolean result = price > priceFrom && price < priceTo;
                    return result;
                })
                .toList();

        return list;
    }
// * 4) Выбрать товары, которые начинаются с определенной(ых) букв.
    @Override
    public List<Item> findAllByName(String letter) {//ab, abc, abcd
        List<Item> list = items
                .stream()
                .filter(item -> item.name().startsWith(letter))
                .toList();

       /* String template = letter + ".*";

        List<Item> list = items
                .stream()
                .filter(item -> {
                    String name = item.name();

                    boolean matches = Pattern.matches(template, name);

                    return matches;
                })
                .toList();*/
        return list;
    }
}
