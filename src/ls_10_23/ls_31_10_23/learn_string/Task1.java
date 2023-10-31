package ls_10_23.ls_31_10_23.learn_string;

/**
 * *** Вывести текст, составленный из последних букв всех слов., split, charAt
 */
public class Task1 {
    public static void main(String[] args) {
        String str = "Hello my young friend";

        String[] words = str.split(" ");

        for (String word : words) {
            char lastSymbol = word.charAt(word.length() - 1);

            System.out.println(lastSymbol);
        }
    }
}
