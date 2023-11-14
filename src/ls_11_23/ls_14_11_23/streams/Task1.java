package ls_11_23.ls_14_11_23.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 5; i++) {

            int value = random.nextInt(1, 5);

            values.add(value);
        }

        int sum = values
                .stream()
                .mapToInt(v -> v * 2)
                .reduce(0, (v1, v2) -> v1 + v2);

//        Math.pow(2, 7)

        System.out.println(sum);

    }
}
