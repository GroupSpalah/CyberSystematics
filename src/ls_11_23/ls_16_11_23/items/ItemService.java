package ls_11_23.ls_16_11_23.items;

import java.time.LocalDate;
import java.util.List;

/**
 *  * 1) Одного производителя, хрупкие
 *  * 2) Товары, произведенные между двумя датами
 *  * 3) Товары, цена которых лежит в определенном промежутке.
 *  * 4) Выбрать товары, которые начинаются с определенной(ых) букв.
 */
public interface ItemService {
    List<Item> findAllByProducerAndCrush(Producer producer);
    List<Item> findAllByBetweenTwoDates(LocalDate from, LocalDate to);
    List<Item> findAllByBetweenPrices(float priceFrom, float priceTo);
    List<Item> findAllByName(String letter);

    public void addItem(Item item);
}
