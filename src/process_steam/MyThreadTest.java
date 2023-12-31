package process_steam;

public class MyThreadTest {
    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();

    }
}
