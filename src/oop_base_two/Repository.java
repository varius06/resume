package oop_base_two;

public class Repository implements MutableDataSource{
    private final DataSource cloud;
    private final MutableDataSource cache;

    public Repository(DataSource cloud, MutableDataSource cache) {
        this.cloud = cloud;
        this.cache = cache;
    }

    @Override
    public MyData data() {
        MyData data = cache.data();
        if(data == null) {
            data = cloud.data();
        }
        return data;
    }

    @Override
    public void saveData(MyData data) {
        cache.saveData(data);
    }
}
