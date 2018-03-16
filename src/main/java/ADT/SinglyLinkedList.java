package ADT;

public class SinglyLinkedList<T> {
    private Node<T> first;

    public SinglyLinkedList(Node<T> first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (!isEmpty()) {
            newNode.next = first;
            first = newNode;
        }
    }

    public void insert(T data) {
        if (isEmpty()) {
            System.out.println("No node have been created");
            System.out.println("Creating new node with data -> " + data);
            insertFirst(data);
            return;
        }

        Node<T> current = first;

        while (current.next != null) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(data);
        current.next = newNode;
    }

    public void insertAfter(T key, T data) {
        if (isEmpty()) {
            throw new NullPointerException("Cannot insert anything - empty list");
        }

        Node<T> current = first;

        while (current != null && !current.getData().equals(key)) {
            current = current.next;
        }

        if (current != null) {
            Node<T> newNode = new Node<>(data);
            Node<T> temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
    }

    public Node<T> deleteFirst() {
        if (isEmpty()) {
            throw new NullPointerException("Nothing to delete");
        }

        Node<T> temp = first;
        first = first.next;
        return temp;
    }

    public Node<T> delete(T key) {
        if (isEmpty()) {
            throw new RuntimeException("The LinkedList is empty");
        }

        Node<T> temp = null;

        if (key.equals(first.getData())) {
            temp = first;
            first = first.next;
            return temp;
        }

        Node<T> current = first;
        Node<T> previous = null;

        while (current != null && !current.getData().equals(key)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            throw new RuntimeException("The LinkedList is empty");
        }

        if (current.getData().equals(key)) {
            temp = current;
        }

        previous.next = current.next;
        return temp;
    }

    public Node<T> deleteLast() {
        if (isEmpty()) {
            throw new NullPointerException("The LinkedList is empty");
        }

        Node<T> current = first;
        Node<T> temp = null;

        while (current != null) {
            if (current.next.next == null) {
                temp = current.next;
                current.next = null;
                break;
            }

            current = current.next;
        }

        return temp;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The LinkedList is empty");
            return;
        }

        Node<T> current = first;

        while (current != null) {
            current.display();
            System.out.print(" -> ");
            current = current.next;
        }
    }

    public int size() {
        int length = 0;

        Node<T> current = first;

        while (current != null) {
            current = current.next;
            length++;
        }

        return length;
    }
}
