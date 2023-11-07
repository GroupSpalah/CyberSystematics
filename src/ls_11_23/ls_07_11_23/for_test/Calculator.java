package ls_11_23.ls_07_11_23.for_test;

import java.io.IOException;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public double divide(double a, double b) {
        if (b < 0) {
            if (b == -1) {
                return -1;
            }
            return -2;
        }

        return a / b;
    }

    public void throwException() throws IOException {
        if (1 == 1) {
            throw new IOException("Incorrect file extension");
        }
    }
}
