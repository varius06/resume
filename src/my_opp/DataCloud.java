package my_opp;

public class DataCloud implements DataSource<Data> {
    @Override
    public Data data() {
        return new Data("DataCloud");
    }
}
