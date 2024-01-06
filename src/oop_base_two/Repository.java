package oop_base_two;

public class Repository<T> implements MutableDataSource<T>{
    private final DataSource<T> cloud;
    private final MutableDataSource<T> cache;

    public Repository(DataSource<T> cloud, MutableDataSource<T> cache) {
        this.cloud = cloud;
        this.cache = cache;
    }

    @Override
    public T data() {
        T data = cache.data();
        if(data == null) {
            data = cloud.data();
        }
        return data;
    }

    @Override
    public void saveData(T data) {
        cache.saveData(data);
    }
}
