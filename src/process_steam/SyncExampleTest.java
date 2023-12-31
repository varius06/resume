package process_steam;

import java.util.concurrent.TimeUnit;

public class SyncExampleTest {

    public static void main(String[] args) throws InterruptedException {
        final SyncExample syncExample = new SyncExample();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    syncExample.add(String.valueOf(i));
                }
            }
        }, "Producer");

        Thread printer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    String s = syncExample.getString();
                    if(s != null) {
                        System.out.println(s);
                    } else {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                }
            }
        }, "Printer");

        producer.start();
        printer.start();
        System.out.println("Threads started");
        TimeUnit.MILLISECONDS.sleep(5000);
        printer.interrupt();
        System.out.println("Threads stopped");
    }

}
