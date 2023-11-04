package ls_11_23.ls_04_11_23.products.with_map;

import java.time.Month;
import java.util.Map;

public class TestMapProduct {
    public static void main(String[] args) {
        ProductMap productMap = new ProductMap();

        productMap.addValue("Bread", Month.OCTOBER, 12.45f);
        productMap.addValue("Bread", Month.MAY, 27.45f);
        productMap.addValue("Bread", Month.APRIL, 37.45f);

        productMap.addValue("Fish", Month.NOVEMBER, 24.45f);
        productMap.addValue("Fish", Month.JANUARY, 17.45f);
        productMap.addValue("Fish", Month.AUGUST, 52.45f);

        float fishPrice = productMap.getPriceByProductNameAndMonth("Fish", Month.JANUARY);

        System.out.println(fishPrice);
    }
}
