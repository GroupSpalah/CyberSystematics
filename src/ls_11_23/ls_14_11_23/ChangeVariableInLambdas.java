package ls_11_23.ls_14_11_23;

class ChangeVariableInLambdas {
    public static void main(String[] args) {

        int a = 10;

        Man man = new Man();

        Convertable<String, Integer> convertable = convert -> {
//            a = 15;
            man.age = 15;
//            man = new Man();
            return Integer.parseInt(convert) + a;
        };

        int sum = convertable.convert("45") + 5;

        System.out.println(sum);
    }
}

class Man {
    public int age;
}