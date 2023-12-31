package collections;

public interface SimpleMap<V, K> {
    V put(K key, V value);

    V get(V key);
}
