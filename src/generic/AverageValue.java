package generic;

public class AverageValue <T extends Number>{
    private T[] array;
    private double sum = 0.0;
    public AverageValue(T[] array) {
        this.array = array.clone();
    }

    public double average() {

        for (T value : array) {
            sum += value.doubleValue();
        }
        return sum / array.length;
    }

    boolean sameAvg(AverageValue<?> ob) {
        return average() == ob.average();
    }
}
