package oop_base_two;

public class TestRepository {
    public static void main(String[] strings) {
        MutableDataSource<MyData> dataSource = new Repository(new MyDataCloudDataSource(), new CacheDataSource<>());
        MyData data = dataSource.data();

        MutableDataSource<GeoData> dataSource1 = new Repository(new GeoCloudDataSource(), new CacheDataSource<>());
        GeoData geoData = dataSource1.data();
    }
}
