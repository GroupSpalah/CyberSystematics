package ls_11_23.ls_04_11_23.products;

import java.time.Month;
import java.util.List;
import java.util.Map;

public class TestProduct {
    public static void main(String[] args) {
        MonthPrice mpAprilMeal = new MonthPrice(Month.APRIL, 12.45f);
        MonthPrice mpOctoberMeal = new MonthPrice(Month.OCTOBER, 23.12f);
        MonthPrice mpMayMeal = new MonthPrice(Month.MAY, 45.72f);

        List<MonthPrice> pricesMeal = List.of(mpAprilMeal, mpOctoberMeal, mpMayMeal);

        Product meal = new Product("Meal", pricesMeal);

        MonthPrice mpNovemberBread = new MonthPrice(Month.NOVEMBER, 56.45f);
        MonthPrice mpFebraryBread = new MonthPrice(Month.FEBRUARY, 72.12f);
        MonthPrice mpMayBread = new MonthPrice(Month.MAY, 85.72f);

        List<MonthPrice> pricesBread = List.of(mpFebraryBread, mpNovemberBread, mpMayBread);

        Product bread = new Product("Bread", pricesBread);

        ProductService productService = new ProductService();

        productService.addProduct(meal);
        productService.addProduct(bread);

        float priceBread = productService.getPriceByMonthAndProduct(Month.NOVEMBER, "Bread");

        System.out.println(priceBread);

    }
}

class Item {
    private Map<Month, Float> map;
}