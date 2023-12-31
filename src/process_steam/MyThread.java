package process_steam;

public class MyThread implements Runnable{
    int counter = 0;
    @Override
    public void run() {
        while (counter < 20) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            System.out.println(Thread.currentThread().getName() + " counter: " + counter);
        }
    }
}
