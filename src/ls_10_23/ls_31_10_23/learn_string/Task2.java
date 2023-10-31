package ls_10_23.ls_31_10_23.learn_string;

/**
 * Дано слово, состоящее из четного числа букв.
 * Вывести на экран его первую половину, не используя оператор цикла., substring
 */
public class Task2 {
    public static void main(String[] args) {
        String str = "friend";

        String substring = str.substring(0, str.length() / 2);

        System.out.println(substring);

    }
}
