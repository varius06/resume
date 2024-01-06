package oop_base_two;

public interface MutableDataSource<T> extends DataSource<T>{
    void saveData(T data);
}
