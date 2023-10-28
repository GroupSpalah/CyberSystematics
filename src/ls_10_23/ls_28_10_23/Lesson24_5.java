package ls_10_23.ls_28_10_23;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Lesson24_5 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(5);
        list.add(7);
        list.add(7);
        list.add(9);
        list.add(3);

        Set<Integer> set = new HashSet<>(list);

        List<Integer> temp = new LinkedList<>(set);

        System.out.println(temp);

    }
}
