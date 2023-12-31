package collections;

public class TreeSimpleMap<V, K> implements SimpleMap<V, K>{
    private Item<V, K> root = null;

    @Override
    public V put(K key, V value) {
        if(root == null) {
            root = new Item<>(key, value);
        } else {
            Item<V, K> current = root;
            while (true) {
                int compareResult = ((Comparable<K>)key).compareTo(current.key);
                if(compareResult == 0) {

                } else if (compareResult < 0) {
                    if(current.left == null) {
                        current.left = new Item<>(key, value);
                        return null;
                    }
                    current = current.left;
                } else {
                    if(current.right == null) {
                        current.right = new Item<>(key, value);
                        return null;
                    }
                    current = current.right;
                }
            }
        }
        return null;
    }

    @Override
    public V get(V key) {
        Item<V,K> current = root;
        while (current != null) {
            int compareResult =  ((Comparable)key).compareTo(current.key);
            if(compareResult == 0) {
                return current.value;
            } else if (compareResult < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public static class Item <V, K>{
        private K key;
        private V value;

        private Item<V, K> left;

        private Item<V, K> right;

        public Item(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
