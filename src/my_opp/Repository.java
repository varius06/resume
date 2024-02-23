package my_opp;


public class Repository<T> implements MutableDataSource<T>{

    private final DataSource<T> dataCloud;
    private  final MutableDataSource<T> dataCash;

    public Repository(DataSource<T> dataCloud, MutableDataSource<T> dataCash) {
        this.dataCash = dataCash;
        this.dataCloud = dataCloud;
    }

    @Override
    public T data() {
        T result = dataCash.data();
        if(result == null) {
            result = dataCloud.data();
        }
        return result;
    }

    @Override
    public void saveData(T data) {
        dataCash.saveData(data);
    }
}
