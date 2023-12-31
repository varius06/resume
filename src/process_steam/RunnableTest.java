package process_steam;

import java.util.concurrent.TimeUnit;

public class RunnableTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("RunnableTest finished");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTest(), "RunnableTest");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main finished");
    }
}
