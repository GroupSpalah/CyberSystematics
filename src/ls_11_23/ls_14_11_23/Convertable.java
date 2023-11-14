package ls_11_23.ls_14_11_23;

@FunctionalInterface
public interface Convertable<T, F> {
    F convert(T t);
}

class TestGenericFI {
    public static void main(String[] args) {
        Convertable<String, Integer> convertable = convert -> {
            int a = 10;
            return Integer.parseInt(convert) + a;
        };

        int sum = convertable.convert("45") + 5;

        System.out.println(sum);
    }
}