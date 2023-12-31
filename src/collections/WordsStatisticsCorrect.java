package collections;

import java.util.*;

public class WordsStatisticsCorrect {
    public static void main(String[] arg){
        String text = "Hello hello java Java JAVA Word world world";
        String[] strings = text.split(" ");
        getStatisticMap(strings);
    }

    private static Map<String, Integer>  getStatisticMap(String[] args){
        Map<String, Integer> hashMap = new HashMap<>();
        Integer count = 0;
        for (String str: args){
            String w = str.toLowerCase();
            count = hashMap.get(w);
            if(count == null) {
                count = 1;
            } else {
                count++;
            }
            hashMap.put(w, count);
        }
        return sort(hashMap);
    }

    public static Map<String, Integer> sort(Map<String, Integer> args) {
        System.out.println(args.entrySet());
        Set<Map.Entry<String, Integer>> treeSetMap = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int result = o1.getValue() - o2.getValue();
                if(result == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return result;
                }
            }
        });
        treeSetMap.addAll(args.entrySet());
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry: treeSetMap) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(linkedHashMap.entrySet());
        return linkedHashMap;
    }
}
