package oop_part_three;

public interface Data {

    interface Save<T> {
        void save(T data);
    }

    interface Read<T> {
        T read();
    }

    interface Mutable<T> extends Save<T>, Read<T> {

    }

    class LocalCache<T> implements Mutable<T> {

        private T data;

        @Override
        public void save(T data) {
            this.data = data;
        }

        @Override
        public T read() {
            return data;
        }
    }
}
