package oop_base_two;

public final class CacheDataSource extends DataSource{
    private MyData data;
    @Override // load data from Bd or form file
    public MyData data() {
        return data;
    }

    @Override // save data from BD or from file
    public void saveData(MyData data) {
        this.data = data;
    }
}
