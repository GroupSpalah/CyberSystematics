package ls_11_23.ls_11_11_23;

import java.io.IOException;

public class LearnThreads {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

//        myThread.start();

//        myThread.run();

//        throw new IOException();

        MyRunnable runnable = new MyRunnable();

        Thread thread = new Thread(runnable, "Vasya");//new state

        thread.start();// from new state to runnable state
//        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm new thread!");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("I'm runnable");
//            throw new IOException();
//        action();
    }

    public void action() {
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}