package ADT;

import java.util.NoSuchElementException;

public class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> last;

    public CircularLinkedList(Node<T> first) {
        this.head = first;
        this.last = first;
    }

    public void insert(T data) {
        if (isEmpty()) {
            throw new NoSuchElementException("Head -> null");
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node<>(data);
        last = current;
    }

    public int search(T data) {
        if (isEmpty()) {
            throw new NoSuchElementException("Head -> null");
        }

        Node<T> current = head;
        int pos = 0;

        while (current != null && data.equals(head.getData())) {
            pos++;
            current = current.next;
        }

        if (current != null && data.equals(head.getData())) {
            return pos;
        }

        return -1;
    }

    public Node<T> delete(T key) {
        if (isEmpty()) {
            throw new NoSuchElementException("Head -> null");
        }

        Node<T> temp = null;

        if (key.equals(head.getData())) {
            temp = head;
            head = head.next;
            last = head;
            return temp;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && key.equals(head.getData())) {
            previous = current;
            current =current.next;
        }

        if (current == null) {
            throw new NoSuchElementException("Head -> null");
        }

        if (key.equals(head.getData())) {
            temp = current;
        }

        previous.next = current.next;
        last = current;
        return temp;
    }

    public void print() {
        Node<T> current = head;

        System.out.print("[ ");

        while(current != null) {
            current.display();
            System.out.print(" -> ");
            current = current.next;
        }

        System.out.print(" ]");

    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }
}
