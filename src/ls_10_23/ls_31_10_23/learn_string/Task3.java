package ls_10_23.ls_31_10_23.learn_string;

/**
 * input: mike_tyson@gmail.com
 *             output: tyson_mike@gmail.com
 */
public class Task3 {
    public static void main(String[] args) {
        String str = "mike_tyson@gmail.com";

        String[] words1 = str.split("@");//[0] - mike_tyson, [1] - gmail.com

        String[] words2 = words1[0].split("_");//[0] - mike, [1] - tyson

        StringBuilder builder = new StringBuilder();

        StringBuilder result = builder
                .append(words2[1])
                .append("_")
                .append(words2[0])
                .append("@")
                .append(words1[1]);

        String s = words2[1] + "_" + words2[0] + "@" + words1[1];
        String s1 = words2[1].concat("_") + words2[0] + "@" + words1[1];

        System.out.println(s);
    }
}
