package process_steam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockUnlock {
    public static void main(String[] strings) {
        List<Resource> resources = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            resources.add(new Resource(i));
        }

        Comparator<Resource> comparator = new Comparator<Resource>() {
            @Override
            public int compare(Resource o1, Resource o2) {
                return resources.indexOf(o1) - resources.indexOf(o2);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                handle(resources.get(0), resources.get(1), comparator);
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                handle(resources.get(1), resources.get(0), comparator);
            }
        });
    }

    public  static void handle(Resource res1, Resource res2, Comparator<Resource> comparator) {

        Object lock1 = res1;
        Object lock2 = res2;

        if(comparator.compare(res1, res2) < 0) {
            lock2 = res1;
            lock1 = res2;
        }
        System.out.println(Thread.currentThread().getName() + " start");
        synchronized (lock1) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                res1.setValue(res2.getValue());
            }
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }

    static class Resource {
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Resource(int value) {
            this.value = value;
        }
    }
}
