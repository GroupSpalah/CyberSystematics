package ls_11_23.ls_18_11_23;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UseIntStream {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
        }

        int[] array = {4, 8, 9, 6};

       /* IntStream
                .rangeClosed(0, 10)
                .forEach(index -> System.out.println(index));*/

        /*IntStream
                .range(0, array.length)
                .forEach(index -> System.out.print(array[index] + "\t"));*/

//        System.out.println(Arrays.toString(array));

     /*   Arrays
                .stream(array)*/
    }
}
