package itertor;

public class AppIterator {
    public static void main(String[] args) {
        ConcreteAggregator concreteAggregator = new ConcreteAggregator();
        Iterator iterator = concreteAggregator.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
