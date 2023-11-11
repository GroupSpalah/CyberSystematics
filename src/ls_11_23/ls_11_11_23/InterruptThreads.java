package ls_11_23.ls_11_11_23;

import java.util.concurrent.TimeUnit;

public class InterruptThreads {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

//        myThread1.stop();
//        myThread1.suspend();

        myThread1.interrupt();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();

        System.out.println("Before sleeping = " + thread.isInterrupted());//not static
        System.out.println("Before sleeping = " + thread.interrupted());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Inside catch = " + thread.isInterrupted());
            thread.interrupt();
            System.out.println("After interrupt = " + thread.isInterrupted());

        }
    }
}
