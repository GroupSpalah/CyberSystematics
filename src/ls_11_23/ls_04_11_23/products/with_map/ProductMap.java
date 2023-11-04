package ls_11_23.ls_04_11_23.products.with_map;

import java.time.Month;
import java.util.*;

public class ProductMap {
   private Map<String, Map<Month, Float>> map;

    public ProductMap() {
        map = new TreeMap<>();
    }

    public void addValue(String name, Month month, float price) {
        if (map.containsKey(name)) {
            Map<Month, Float> map1 = map.get(name);

            map1.put(month, price);
        } else {
            Map<Month, Float> map2 = new HashMap<>(Map.of(month, price));
            map.put(name, map2);
        }
    }

    public float getPriceByProductNameAndMonth(String name, Month month) {
        Set<Map.Entry<String, Map<Month, Float>>> entries = map.entrySet();

        Iterator<Map.Entry<String, Map<Month, Float>>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Map<Month, Float>> entry = iterator.next();

            if (entry.getKey().equals(name)) {
                Map<Month, Float> value = entry.getValue();

                Set<Map.Entry<Month, Float>> set = value.entrySet();

                Iterator<Map.Entry<Month, Float>> iteratorMP = set.iterator();

                while (iteratorMP.hasNext()) {
                    Map.Entry<Month, Float> mp = iteratorMP.next();

                    if (mp.getKey() == month) {
                        return mp.getValue();
                    }
                }
            }
        }

        return 0;
    }
}
