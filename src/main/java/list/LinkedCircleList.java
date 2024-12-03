package list;

public class LinkedCircleList<T> {
    private Node<T> first;
    private Node<T> last;
    private Node<T> top = first;
    private int length;

    public LinkedCircleList(Node<T> first, Node<T> last, int length) {
        this.first = first;
        this.last = last;
        this.length = length;
    }

    public LinkedCircleList() {
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void addEnd(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null && last == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(top);
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
            first.setPrevious(last);
            last.setNext(first);
        }
        length++;
    }

    public void addBeginning(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null && last == null) {
            first = newNode;
            last = newNode;
        } else {
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;
            first.setPrevious(last);
            last.setNext(first);
        }
        length++;
    }

    public void add(T element, int position) {
        if (position == 0) {
            addBeginning(element);
        } else if (position + 1 == length) {
            addEnd(element);
        } else {
            Node<T> node = get(position);
            Node<T> newNode = new Node<>(element);

            newNode.setNext(node);
            newNode.setPrevious(node.getPrevious());
            node.setPrevious(newNode);
        }
    }

    public Node<T> get(int position) {
        Node<T> current = first;
        for (int i = 0; i < position; i++) {
            if (current.getNext() != null) {
                current = current.getNext();
            } else {
                return null;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        LinkedCircleList list = new LinkedCircleList();
        // adicionar no final
        list.addEnd("D");
        list.addEnd("E");
        list.addEnd("F");
        list.addEnd("G");
        list.addEnd("H");
        list.addEnd("I");
        // adicionar no começo
        list.addBeginning("C");
        list.addBeginning("B");
        list.addBeginning("A");
        list.addBeginning("0");

        // adicionar na posição
        list.add("2", 3);
        System.out.println("Tamanho: " + list.getLength());
        System.out.println("Primeiro: " + list.getFirst().getValue());
        System.out.println("Último: " + list.getLast().getValue());
        for (int i = 0; i < list.getLength(); i++) {
            if (i == 0) {
                System.out.println(list.get(i).getPrevious().getValue());
            }
            System.out.println(list.get(i).getValue());
        }

    }
}