package oop_base_two;

public class TestRepository {
    public static void main(String[] strings) {
        MutableDataSource dataSource = new CacheDataSource();
        dataSource.saveData(new MyData(1, "1"));
    }
}
