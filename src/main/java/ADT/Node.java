package ADT;

public class Node<T> {
    private T data;
    public Node next = null;

    public Node(T data) {
        this.data = data;
    }

    public static int size(Node<Integer> node) {
        int length = 0;

        Node<Integer> current = node;

        while (current != null) {
            current = current.next;
            length++;
        }

        return length;
    }
}
