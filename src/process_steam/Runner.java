package process_steam;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        final Thread mainThread = Thread.currentThread();
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.join();
                } catch (InterruptedException e) {

                }
                showThreadState(Thread.currentThread());
            }
        });
        thread.start();
        Thread.sleep(1000);
        showThreadState(thread);

    }

    private static void showThreadState(final Thread thread) {
        System.out.println(thread.getName() + " " + thread.getState());
    }
}
