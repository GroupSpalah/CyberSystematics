package ls_11_23.ls_04_11_23.generics;

public class ArrayUtil {
    public static <T extends Number> double averageValue(Array<T> array) {

        double sum = 0;

        for (int i = 0; i < array.length(); i++) {
            sum += array.get(i).doubleValue();
        }

        return sum / array.length();

    }
}

class TestArray {
    public static void main(String[] args) {
        Float[] arrF = {12.45f, 4.78f, 14.9F, 78.6F};
        Array<Float> array = new Array<>(arrF);

        double avg = ArrayUtil.averageValue(array);

        System.out.println(avg);
    }
}
