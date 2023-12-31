package process_steam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SyncExample {
    private List<String> list = new ArrayList<>();
    private int count = 0;

    public synchronized void add(String str) {
        count++;
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.add(str);
    }

    public synchronized String getString() {
        if(count > 0) {
            count--;
            return list.remove(count);
        } else {
            return null;
        }

    }
}
