package arraylist;

public class AppSimpleArray {
    public static void main(String[] args) {
        Simple<String> strings = new SimpleArray<>();
        strings.add("One");
        strings.add("Two");
        strings.add("Privet");
        for (String e : strings) {
            System.out.println(e);
        }
    }
}
