package process_steam;

public class Notifier implements Runnable{
    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " ���������");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMessage(name + " ����� Notifier ���������");
                msg.notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
