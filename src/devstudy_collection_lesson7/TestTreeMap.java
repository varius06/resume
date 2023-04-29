package devstudy_collection_lesson7;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        String text = "Hello hello java Java java world";
        String[] words = text.split(" ");
        Map<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            treeMap.put(i, words[i]);
        }
        String pr = " ";
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();

        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            //Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) set.iterator().next();
            System.out.println(iterator.next());
        }
        String pp = " ";
    }
}
