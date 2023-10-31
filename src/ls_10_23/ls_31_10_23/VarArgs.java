package ls_10_23.ls_31_10_23;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
//        int[] arr = {7, 8, 9};

//        print(arr);

        print1(8, 1, 2, 7, 9);
    }

    public static void print(int[] array) {

    }

    public static void print1(int a, int... array) {//var args
        System.out.println(Arrays.toString(array));
    }
}
