package process_steam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;

public class CallableExample implements Callable {
    private String word;

    CallableExample(String word) {
        this.word = word;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Длина слова: " + word.length());
        return word.length();
    }

    public static void main(String[] strings) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Set<Future<Integer>> set = new HashSet<>();
        for (String str: split) {
            Callable<Integer> callable = new CallableExample(str);
            Future<Integer> future = executorService.submit(callable);
            set.add(future);
        }

        int sum = 0;
        for(Future<Integer> future: set) {
            sum += future.get();
        }
        System.out.println("Sum: " + sum);
        executorService.shutdown();
    }
}
