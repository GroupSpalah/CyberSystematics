package ls_10_23.ls_31_10_23.learn_string;

import java.util.Arrays;
import java.util.TimeZone;

public class Task4 {
    public static void main(String[] args) {
        String name = "john";

        char firstSymbol = name.charAt(0);//'j'

        String symbolAsString = String.valueOf(firstSymbol).toUpperCase();//"J"

        String lastPart = name.substring(1);//"ohn"

        System.out.println(symbolAsString + lastPart);

//        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
