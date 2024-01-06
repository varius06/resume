package oop_base_two;

public class Repository extends DataSource{
    private final DataSource cloud;
    private final DataSource cache;

    public Repository(DataSource cloud, DataSource cache) {
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
