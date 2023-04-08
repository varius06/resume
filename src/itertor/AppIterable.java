package itertor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AppIterable {
    public static void main(String[] args) {
        SimpleIterableObject iterableObject = new SimpleIterableObject();
        for (Object o : iterableObject) {
            System.out.println(o);
        }

        SimpleIterableGeneric<String> iterableGeneric = new SimpleIterableGeneric<>();
        for (String o : iterableGeneric) {
            System.out.println(o);
        }


        List<String> colors = new ArrayList<>(Arrays.asList("Blue", "Red", "Green"));
        // обход списка с помощью итератора
        for (Iterator<String> itr = colors.iterator(); itr.hasNext();) {
            System.out.println(itr.next());
        }
    }
}
