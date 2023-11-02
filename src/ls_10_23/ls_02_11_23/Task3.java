package ls_10_23.ls_02_11_23;

import java.util.regex.Pattern;
public class Task3 {
    public static void main(String[] args) {
        String text = "A123";
        String template = "[ABCEHKMOPTXY]\\d{3}[ABCEHKMOPTXY]{2}";

        System.out.println(Pattern.matches(template, text));

    }
}
