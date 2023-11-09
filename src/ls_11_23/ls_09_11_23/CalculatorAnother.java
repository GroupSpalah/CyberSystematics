package ls_11_23.ls_09_11_23;

import java.util.Random;

public class CalculatorAnother {
    public int sum(int a) {//5
//        this.print();
        return a + getRandom();
    }

    public int getRandom() {//15
        return new Random().nextInt(50);//0-49
    }

    public void print() {
        System.out.println("Hello");
    }
}
/*
Mock class CalculatorMockito


public class CalculatorMockito {
    public int sum(int a) {
        return 0;
    }

    public int getRandom() {
        return 0;
    }
}*/
