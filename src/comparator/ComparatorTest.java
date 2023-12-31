package comparator;

import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Comparator<Character> reverseOrder = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        };
        Character[] array1 = { 'b', 'd', 'a', 'g', 'h', 'z' };
        System.out.println(findMax(array1, null));


    }

    public static <T> T findMax(T[] array, Comparator<T> comparator) {
        return find(array, comparator, new CompareCallback() {
            @Override
            public boolean shouldUpdateResult(int compareResult) {
                return compareResult > 0;
            }
        });
    }

    private static <T> T find(T[] array, Comparator<T> comparator, CompareCallback compareCallback) {
        T result = array[0];
        Comparator<T> presetComparator = getValidComparator(comparator, result);
        for (int i = 0; i < array.length; i++) {
            if(compareCallback.shouldUpdateResult(presetComparator.compare(array[i], result))) {
                result = array[i];
            }
        }
        return result;
    }

    private static interface CompareCallback {
        boolean shouldUpdateResult(int compareResult);
    }

    private static <T> Comparator<T> getValidComparator(Comparator<T> comparator, T arrayElement) {
        if(comparator != null) {
            return comparator;
        } else {
            if(arrayElement instanceof Comparable) {
                comparator = new Comparator<T>() {
                    @Override
                    public int compare(T o1, T o2) {
                        return ((Comparable<T>) o1).compareTo(o2);
                    }
                };
            }
        }
        return comparator;
    }

}
