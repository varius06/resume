package oop_base_two;

public final class CloudDataSource extends DataSource{
    @Override
    public MyData data() {
        return new MyData(1, "1");
    }

    @Override
    public void saveData(MyData data) {

    }
}
