package oop_base_two;

public class GeoCloudDataSource implements DataSource<GeoData>{
    @Override
    public GeoData data() {
        return new GeoData(3.1, 4.5);
    }
}
