package ls_11_23.ls_11_11_23;

public class UseJoin {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();

        Thread thread = new Thread(worker);

//        thread.setDaemon(true);

        thread.start();

        thread.join();

        System.out.println("Finish main");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        while (true) {

        }
    }
}
