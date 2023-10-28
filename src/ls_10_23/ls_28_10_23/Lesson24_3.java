package ls_10_23.ls_28_10_23;

import java.util.*;


public class Lesson24_3 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(5);//0
        list.add(7);//1
        list.add(9);//2
        list.add(3);//3

        /*list.set(2, 88);

        System.out.println(list.get(2));*/

       /* System.out.println(list.getFirst());
        System.out.println(list.getLast());*/

        list.addFirst(10);
        list.addLast(15);
        System.out.println(list);

    }
}
