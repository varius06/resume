package oop_base_two;

public final class MyDataCloudDataSource implements DataSource<MyData>{
    @Override
    public MyData data() {
        return new MyData(1, "1");
    }
}
