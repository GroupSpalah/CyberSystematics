package ls_10_23.ls_02_11_23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Пользователь вводит имя и фамилию. Буквы могут быть в разных регистрах.
 * Проверить, чтобы первые буквы были в верхнем регистре, а остальные буквы - в нижнем.
 */
public class Task2 {
    public static void main(String[] args) {
        String text = "Andrey Valevskiy";
        String template = "[A-Z]{1}[a-z]{5,30}\\s{1}[A-Z]{1}[a-z]{5,30}";

        System.out.println(Pattern.matches(template, text));

    }
}
