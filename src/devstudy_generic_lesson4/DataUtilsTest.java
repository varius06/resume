package devstudy_generic_lesson4;

public class DataUtilsTest {
    public static void main(String[] args) {
        LinkedList<Integer> result = DataUtilsComparator.newLinkedListWithDuplicates(testLinkedList(0), testLinkedList(5),
                testDynaArray(10), testLinkedList(15), testDynaArray(20));
        System.out.println("withDuplicates=" + result);

        result = DataUtilsComparator.newLinkedListWithDuplicates(new LinkedList<Integer>(), testLinkedList(5), testDynaArray(10),
                testLinkedList(15), testDynaArray(20));
        System.out.println("withDuplicates=" + result);

        DataSet<Integer> unique = DataUtilsComparator.newDataSetWithoutDuplicates(testLinkedList(0), testLinkedList(5),
                testDynaArray(0), testLinkedList(0), testDynaArray(10));
        System.out.println("unique.getClass()=" + unique.getClass());
        System.out.println("unique=" + unique);
        unique.add(0);
        unique.add(0);
        unique.add(0);
        System.out.println("unique=" + unique);
        System.out.println("----------------------immutable----------------------------");
        DataSet<Integer> immutable = DataUtilsComparator.newImmutableDataSet(result);
        System.out.println("immutable=" + immutable);
        immutable.clear();
        immutable.remove(0);
        immutable.add(333333);
        Object[] array = immutable.toArray();
        array[0] = null;
        System.out.println("immutable=" + immutable);
        System.out.println("immutable.size()=" + immutable.size());
        System.out.println("immutable.get(0)=" + immutable.get(0));
        System.out.println("immutable.getClass()=" + immutable.getClass());

        immutable = DataUtilsComparator.newImmutableDataSet(1, 2, 3);
        immutable.clear();
        immutable.remove(0);
        immutable.add(333333);
        System.out.println("immutable=" + immutable);
        System.out.println("immutable.size()=" + immutable.size());
        System.out.println("immutable.get(0)=" + immutable.get(0));
        System.out.println("immutable.getClass()=" + immutable.getClass());

        immutable = DataUtilsComparator.newImmutableDataSet(new Integer[] { 1, 2, 3 });
        immutable.clear();
        immutable.remove(0);
        immutable.add(333333);
        System.out.println("immutable=" + immutable);
        System.out.println("immutable=" + immutable);
        System.out.println("immutable.size()=" + immutable.size());
        System.out.println("immutable.get(0)=" + immutable.get(0));
        System.out.println("immutable.getClass()=" + immutable.getClass());

        Queue<Integer> queue = DataUtilsComparator.newQueue(testLinkedList(0));
        queue.add(55);
        System.out.println("queue=" + queue);
        queue = DataUtilsComparator.newQueue(testDynaArray(5));
        System.out.println("queue=" + queue);
        queue = DataUtilsComparator.newQueue(new Integer[] { 1, 2, 3 });
        System.out.println("queue=" + queue);

        Stack<Integer> stack = DataUtilsComparator.newStack(testLinkedList(0));
        System.out.println("stack=" + stack);
        stack = DataUtilsComparator.newStack(testDynaArray(5));
        System.out.println("stack=" + stack);
        stack = DataUtilsComparator.newStack(new Integer[] { 1, 2, 3 });
        System.out.println("stack=" + stack);
    }

    private static DataSet<Integer> testLinkedList(int start) {
        DataSet<Integer> list = new LinkedList<>();
        for (int i = start; i < start + 5; i++) {
            list.add(i);
        }
        return list;
    }

    private static DataSet<Integer> testDynaArray(int start) {
        return new DynaArray<>(new Integer[] { start, start + 1, start + 2, start + 3, start + 4 });
    }
}
