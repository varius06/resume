package generic;

public class GenericTest {
    public static void main(String[] args) {
        GenericData<Integer> gen = new GenericData<>();
        Data<Integer> data  = gen.processing(1, 2, 3);
        gen.setValue(4, 6, 8);
        System.out.println("data=" + data);
        System.out.println("gen=" + gen);
    }
}
