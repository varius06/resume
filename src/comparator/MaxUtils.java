package comparator;

import java.util.Comparator;

public class MaxUtils {
    public static void main(String[] args) {
        String[] array1 = { "a", "b", "cc", "den", "eff", "jack" };
        System.out.println(findMax(array1));

        String[] array3 = { "simple", "a new game", "big boss", "Java forever",
                "London is a capital of Great Britain" };
        System.out.println(findMax(array3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }));
    }

    private static <T> T findMax(T[] array){
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(((Comparable<T>) array[i]).compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    private static <T> T findMax(T[] array, Comparator<T> comparator) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(comparator.compare(array[i], max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}
