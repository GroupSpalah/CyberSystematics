package ls_10_23.ls_02_11_23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * В строке содержутся слова и числа.
 * Необходмо выделить числа и посчитать их сумму.
 */
public class Task1 {
    public static void main(String[] args) {
        String text = "Hello7mydear9friend6";//22
        String template = "\\d";

        Pattern pattern = Pattern.compile(template);

        Matcher matcher = pattern.matcher(text);

        int sum = 0;

        while (matcher.find()) {
            String digit = matcher.group();
//            System.out.println(digit);

            int value = Integer.parseInt(digit);//String -> int

            sum += value;
        }

        System.out.println(sum);
    }
}
