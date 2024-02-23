package my_opp;

public class RepositoryTest {
    public static void main(String[] strings) {
        MutableDataSource<Data> mutableDataSource = new Repository<>(new DataCloud(), new DataCash());
    }
}
