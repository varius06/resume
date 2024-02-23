package my_opp;

public class DataCash<T> implements MutableDataSource<T>{

    private T data;

    @Override
    public T data() {
        return data;
    }

    @Override
    public void saveData(T data) {
        this.data = data;
    }
}
