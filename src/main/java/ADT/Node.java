package ADT;

public class Node<T> {
    private T data;
    public Node next;

    public Node(T data) {
        this.data = data;
    }

    public static int size(Node<?> node) {
        int length = 0;

        Node<?> current = node;

        while (current != null) {
            current = current.next;
            length++;
        }

        return length;
    }

    public void display() {
        System.out.print(data);
    }

    @Override
    public String toString() {
        String str = "";
        str += data;
        return str;
    }

    public T getData() {
        return data;
    }
}
