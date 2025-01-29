package list;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.addEnd("A");
        list.addEnd("B");
        list.addEnd("C");
        list.addEnd("D");
        list.addEnd("E");

        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }

        list.remove("C");

        System.out.println("Remove:");

        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.get(i).getValue());
        }


    }
}