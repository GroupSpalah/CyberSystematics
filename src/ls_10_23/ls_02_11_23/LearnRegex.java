package ls_10_23.ls_02_11_23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegex {
    public static void main(String[] args) {
        /*String text = "Hello";
        String template = "H.llo";//any symbol*/

        /*String text = "Hillo";
        String template = "H[ae]llo";//or a or e symbols*/
/*
        String text = "Hillo";
        String template = "H[ae]llo";//or a or e symbols*/

        /*String text = "Hillo";
        String template = "H[a-e]llo";//from a to e symbols*/

        /*String text = "Hcllo";
        String template = "H[a-t&&[^cd]]llo";//from a to t symbols, exclude c and d symbols*/

        /*String text = "Hcllo";
        String template = "H[a-t&&[^cd]]llo";//from a to t symbols, exclude c and d */

        /*String text = "H8llo";
        String template = "H[0-9]llo";//from 0 to 9 digits*/

        /*String text = "H8llo";
        String template = "H\\dllo";//from 0 to 9 digits*/

        /*String text = "H llo";
        String template = "H\\sllo";//must be space symbol*/

       /* String text = "H#llo";
        String template = "H\\Wllo";//must be space symbol*/

        /*String text = "Hgunllo";
        String template = "H(run|gun)llo";//or gun or run words*/

        /** Quantors*/

        /*String text = "Habnhllo";
        String template = "H.*llo";//any symbol any times*/

        /*String text = "Heello";
        String template = "He{2}llo";//e symbol must be 2 times*/

        /*String text = "Heeello";
        String template = "He{2,5}llo";//e symbol must be 2 times*/

       /* String text = "az8";
        String template = "([a-zA-Z0-9]){1,3}";*/

/*        String text = "aWErtc9912";
        String template = "([a-zA-Z0-9&&[^f]]){1,10}";*/

        /*String text = "abv345BCD";
        String template = "([a-zA-Z0-9&&[^fer]]){1,10}";*/

        /*String text = "adb99 ";
        String template = "([a-zA-Z0-9]){1,10}[\\s]";*/
/*
        String text = "abcdrrunritf";
        String template = ".*(run|gun).*";*/

        String text = "acDC7    ";
        String template = "([a-zA-Z0-9]){1,10}(\\s){0,10}";

        /*boolean matches = Pattern.matches(template, text);
        System.out.println(matches);*/

        Pattern pattern = Pattern.compile(template);

        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.matches());
    }
}
