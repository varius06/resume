package linkidlist;

public class AppLinkedList {
    public static void main(String[] args) {
        LinkedContainer<String> linkedContainer = new LinkedContainer<>();
        linkedContainer.addLast("one");
        linkedContainer.addLast("two");
        System.out.println(linkedContainer.size());
        System.out.println(linkedContainer.getElementByIndex(1));

        for (String e : linkedContainer) {
            System.out.println(e);
        }
    }
}
