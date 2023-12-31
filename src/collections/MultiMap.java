package collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MultiMap <K, V>{

    void put(K key, V value);

    void put(Map<K, V> map);

    Collection<V> get(K key);

    Collection<V> remove(K key);

    Set<Map.Entry<K, Collection<V>>> entrySet();

    Collection<V> values();

    boolean containsKey(K key);

    boolean containsValue(V value);


}
