package ls_10_23.ls_31_10_23.learn_string;

public class LearnStringBuilder {
    public static void main(String[] args) {
        String str = "Hello";

        StringBuilder builder = new StringBuilder(str);

        for (int i = 0; i < 10; i++) {
//            str = str + i;

            builder.append(i);
        }

        System.out.println(builder);
        System.out.println(builder.reverse());
    }
}

/**
 * iter0: i == 0, str = Hello0, Hello
 * iter1: i == 1, str = Hello01, Hello0
 * iter2: i == 2, str = Hello012, Hello01
 * iter3: i == 3, str = Hello0123, Hello012
 */
