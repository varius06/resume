package oop_base_two;

public final class CacheDataSource<T> implements MutableDataSource<T>{
    private T data;
    @Override // load data from Bd or form file
    public T data() {
        return data;
    }

    @Override // save data from BD or from file
    public void saveData(T data) {
        this.data = data;
    }
}
