package ls_11_23.ls_18_11_23.pattern.behavorial;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Strategy {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>(List.of(7, -9, 1, 3, -11));

        Sorting ascSort = new AscSorting();
        Sorting descSort = new DescSorting();

        StrategyClient client = new StrategyClient(descSort);

        client.action(list);

        System.out.println(list);
    }
}

interface Sorting {
    void sort(List<Integer> list);
}

class AscSorting implements Sorting {
    @Override
    public void sort(List<Integer> list) {
        Collections.sort(list);
    }
}

class DescSorting implements Sorting {
    @Override
    public void sort(List<Integer> list) {

//        Comparator<Integer> comparator = Integer::compareTo;
        Comparator<Integer> comparator = (v1, v2) -> Integer.compare(v1, v2);

        Collections.sort(list, comparator.reversed());
    }
}

class StrategyClient {
    private Sorting sorting;

    public StrategyClient(Sorting sorting) {
        this.sorting = sorting;
    }

    public void action(List<Integer> list) {
        sorting.sort(list);
    }
}
