package my_opp;

public interface MutableDataSource<T> extends DataSource<T>{
    void saveData(T data);
}
