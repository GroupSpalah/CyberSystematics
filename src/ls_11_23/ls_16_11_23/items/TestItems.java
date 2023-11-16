package ls_11_23.ls_16_11_23.items;

import java.time.LocalDate;
import java.util.List;

/**
 * Товар(название, дата производства, производитель, хрупкость, цена),
 * Производитель товара(название фирмы, страна производства).
 *
 * Выбрать товары:
 * 1) Одного производителя, хрупкие
 * 2) Товары, произведенные между двумя датами
 * 3) Товары, цена которых лежит в определенном промежутке.
 * 4) Выбрать товары, которые начинаются с определенной(ых) букв.
 */
public class TestItems {
    public static void main(String[] args) {
        Producer lenovo = new Producer("Lenovo", Country.USA);
        Producer apple = new Producer("Apple", Country.CANADA);

        Item notebook = new Item("Notebook", LocalDate.now(), lenovo, true, 12.45f);
        Item phone = new Item("Phone", LocalDate.now(), apple, true, 23.45f);

        ItemService itemService = new ItemServiceImpl();

        itemService.addItem(notebook);
        itemService.addItem(phone);

        List<Item> list = itemService.findAllByName("Not");

        System.out.println(list);
    }
}


