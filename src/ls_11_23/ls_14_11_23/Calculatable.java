package ls_11_23.ls_14_11_23;

@FunctionalInterface
public interface Calculatable {
    int action(int a, int b);
//    int action1(int a, int b);

    default void print() {

    }

    private void prMethod() {

    }
}

/*class Calculator implements Calculatable {

}*/

class TestLambdas {
    public static void main(String[] args) {
       /* Calculatable sum = new Calculatable() {
            @Override
            public int action(int a, int b) {
                return a + b;
            }
        };*/

        int c = 10;
        c = 15;

        Calculatable sum = (int d, int b) -> d + b;
//        sum = (a, b) -> a * 2 + b * 2;

       /* Calculatable minus = new Calculatable() {
            @Override
            public int action(int a, int b) {
                return a - b;
            }
        };*/

         Calculatable minus = (a, b) -> a - b;

        int sumResult = sum.action(5, 4);
        int minusResult = minus.action(5, 4);

        /*System.out.println(sumResult);
        System.out.println(minusResult);*/

//        var concat = concat(minus, 5, 8);
        var concat = new int[10];

        int concat1 = concat((a, b) -> a - b, 5, 8);
    }

    public static int concat(Calculatable calculatable, int a, int b) {
        return calculatable.action(a, b);
    }
}
