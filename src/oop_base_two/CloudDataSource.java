package oop_base_two;

public final class CloudDataSource implements DataSource{
    @Override
    public MyData data() {
        return new MyData(1, "1");
    }
}
