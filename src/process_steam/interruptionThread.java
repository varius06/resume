package process_steam;

import java.time.Year;
import java.util.concurrent.TimeUnit;

public class interruptionThread {
    public static void main(String[] args) throws InterruptedException {

        final Thread communicationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        doRequest();
                        System.out.println(Thread.currentThread().isInterrupted());
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted");
                }
            }
        });
        communicationThread.start();

        final Thread stoppingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                communicationThread.interrupt();
                stopServer();
            }
        });
        Thread.sleep(5000);
        stoppingThread.start();
    }

    private static void doRequest() throws InterruptedException {
        System.out.println("Request was sent");
        //Thread.sleep(1000);
        System.out.println("Request was received");
    }

    private static boolean isServerStop() {
        return true;
    }

    private static void stopServer() {
        System.out.println("Server was stopped");
    }
}
