package ls_11_23.ls_07_11_23.annotations;

import java.lang.reflect.Method;

public class MathOperation {

    @Math(num1 = 100, num2 = 200)
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        MathOperation mathOperation = new MathOperation();

        Method methodSum = mathOperation.getClass().getMethod("sum", int.class, int.class);

        Math annotation = methodSum.getAnnotation(Math.class);

        int value1 = annotation.num1();
        int value2 = annotation.num2();

        int sum = mathOperation.sum(value1, value2);

        System.out.println(sum);
    }
}
