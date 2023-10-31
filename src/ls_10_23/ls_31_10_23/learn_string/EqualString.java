package ls_10_23.ls_31_10_23.learn_string;

public class EqualString {
    public static void main(String[] args) {
        String s1 = "Hello";//pool
        String s2 = new String("HeLLo");//Heap
        String s3 = "HeLLo";//pool

//        s2 = s1;

//        System.out.println(s1 == s3);
        System.out.println(s1.equalsIgnoreCase(s2));
    }
}
