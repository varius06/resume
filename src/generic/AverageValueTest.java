package generic;

public class AverageValueTest {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        AverageValue<Integer> iob = new AverageValue<>(intArray);
        System.out.println("������� �������� ��� Integer " + iob.average());

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        AverageValue<Double> dob = new AverageValue<>(doubleArray);
        System.out.println("������� �������� ��� Double " + dob.average());

        System.out.print("������� �������� ��� iob � dob ");
        if (iob.sameAvg(dob)) {
            System.out.println("����������.");
        } else {
            System.out.println("������.");
        }
    }
}
