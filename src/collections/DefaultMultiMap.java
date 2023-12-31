package collections;

import java.util.*;

public class DefaultMultiMap <K, V> implements MultiMap<K, V>{

    private Map<K, Collection<V>> map;

    private DefaultMultiMap(Map<K, Collection<V>> map) {
        this.map = map;
    }

    public static <K, V> DefaultMultiMap<K, V> newMultiHashMap(){
        return new DefaultMultiMap<>(new HashMap<K, Collection<V>>());
    }

    public static <K, V> DefaultMultiMap<K, V> newMultiLinkedHashMap(){
        return new DefaultMultiMap<>(new LinkedHashMap<K, Collection<V>>());
    }

    public static <K, V> DefaultMultiMap<K, V> newMultiTreeMap(){
        return new DefaultMultiMap<>(new TreeMap<K, Collection<V>>());
    }

    @Override
    public void put(K key, V value) {
        Collection<V> list = map.get(key);
        if(list == null) {
            list = new LinkedList<>();
            list.add(value);
            map.put(key, list);
        } else {
            list.add(value);
        }
    }

    @Override
    public void put(Map<K, V> map) {
        for (Map.Entry<K, V> entry: map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Collection<V> get(K key) {
        return map.get(key);
    }

    @Override
    public Collection<V> remove(K key) {
        return map.remove(key);
    }

    @Override
    public Set<Map.Entry<K, Collection<V>>> entrySet() {
        return map.entrySet();
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = new LinkedList<>();
        for (Map.Entry<K, Collection<V>> entry : map.entrySet()) {
            collection.addAll(entry.getValue());
        }
        return collection;
    }

    @Override
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        for (Map.Entry<K, Collection<V>> entry: map.entrySet()){
            if(entry.getValue().contains(value)) {
                return true;
            }
        }
        return false;
    }
}
