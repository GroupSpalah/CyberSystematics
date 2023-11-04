package ls_11_23.ls_04_11_23.products;

import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public float getPriceByMonthAndProduct(Month month, String productName) {
        Iterator<Product> iteratorProduct = products.iterator();

        while (iteratorProduct.hasNext()) {
            Product product = iteratorProduct.next();

            if (product.name().equals(productName)) {
                List<MonthPrice> monthPrices = product.monthPrices();

                Iterator<MonthPrice> mpIterator = monthPrices.iterator();

                while (mpIterator.hasNext()) {
                    MonthPrice monthPrice = mpIterator.next();

                    if (monthPrice.month() == month) {
                        return monthPrice.price();
                    }
                }
            }
        }

        return 0;

    }
}
