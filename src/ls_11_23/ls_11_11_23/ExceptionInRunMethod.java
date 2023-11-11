package ls_11_23.ls_11_11_23;

import java.io.IOException;

public class ExceptionInRunMethod {
    public static void main(String[] args) {
//        print();
    }

    public static void print() throws IOException {
        throw new IOException();
    }
}
