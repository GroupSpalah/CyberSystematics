package ls_10_23.ls_31_10_23.learn_string;

public class LearnString {
    public static void main(String[] args) {
        char c = 'H';//Hello

        char[] word = {'H', 'e', 'l', 'l', 'o'};
//                     01234
        String str1 = "Hello";//object-literal
        String str2 = new String("Hello");//object

        char symbol = str1.charAt(2);

        int indexL = str1.indexOf("l");

//        System.out.println(indexL);

//        System.out.println(symbol);

//        System.out.println(str1);

        int lengthStr = str1.length();

        for (int i = 0; i < lengthStr; i++) {
            char element = str1.charAt(i);

//            System.out.println(element);
        }

        String sentence = "Hello#my#young#friend";

        String[] words = sentence.split("#");//[0] - Hello, [1] - my

        for (String w : words) {
            int length = w.length();
//            System.out.println(length);
        }
//                     0123456789
        String str3 = "Relationsh";

        String substring = str3.substring(3, 6);
        String substring1 = str3.substring(3);
        str3 = str3.substring(3);
/*
        System.out.println(substring1);
        System.out.println(str3);*/

        String charAsString = String.valueOf(symbol);

        String lowerCase = str3.toLowerCase();
        String upperCase = str3.toUpperCase();

    /*    System.out.println(lowerCase);
        System.out.println(upperCase);*/

        String replace = str3.replace('a', 'w');

//        System.out.println(replace);

        //0....200, substring(0, length() / 2),
    }
}
