package collections;

public class HashSimpleMap<K, V> implements SimpleMap<V, K>{

    private Item<V, K>[] refArray = new Item[5];

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % refArray.length;
        Item<V, K> current = refArray[index];
        while (current != null && current.next != null) {
            current = current.next;
        }
        if (current == null) {
            Item<V, K> item = new Item<>(key, value);
            refArray[index] = item;
        } else {
            current.next = new Item<>(key, value);
        }
        return null;
    }

    @Override
    public V get(V key) {
        int index = key.hashCode() % refArray.length;
        Item<V, K> current = refArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private static class Item <V, K>{
        private Item<V, K> next;
        private K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
