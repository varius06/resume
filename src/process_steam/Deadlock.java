package process_steam;

public class Deadlock {
    public static void main(String[] strings) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                synchronized (lock1) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2) {

                    }
                }
                System.out.println(Thread.currentThread().getName() + " end");
            }
        }, "Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                synchronized (lock2) {
                    synchronized (lock1) {

                    }
                }
                System.out.println(Thread.currentThread().getName() + " end");
            }
        }, "Thread2");
        thread1.start();
        thread2.start();
    }
}
