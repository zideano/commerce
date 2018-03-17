package ADT;

public class SinglyLinkedList<T> {
    private Node<T> first;

    public SinglyLinkedList(Node<T> first) {
        this.first = first;
    }

    /**
     *
     * @return if LinkedList is empty or not.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     *
     * @param data to be inserted at the front of the LinkedList
     */
    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (!isEmpty()) {
            newNode.next = first;
            first = newNode;
        }
    }

    /**
     * Traverse the LinkedList until the end is reached.
     *
     * @param data to be inserted at the end of the LinkedList
     */
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

        current.next = new Node<>(data);
    }

    /**
     * The insertAfter method traverse the LinkedList until
     * a match of the key is found or not.
     *
     * @param key to search for in the LinkedList
     * @param data that will be inserted if key present
     */
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

    /**
     *
     * @return the deleted first node
     */
    public Node<T> deleteFirst() {
        if (isEmpty()) {
            throw new NullPointerException("Nothing to delete");
        }

        Node<T> temp = first;
        first = first.next;
        return temp;
    }

    /**
     * Search the LinkedList for the node with the first match
     * of the key.
     *
     * @param key is node to be deleted if matched
     * @return the deleted node if the key is present
     */
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

        assert previous != null;
        previous.next = current.next;
        return temp;
    }

    /**
     * This delete method will traverse the LinkedList
     * until the end of the list is reached, then the
     * link to the last element is return and deleted
     *
     * @return the deleted element from the last position
     */
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

    public int search(T key) {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }

        Node<T> current = first;
        int pos = 0;

        while (current != null && !key.equals(current.getData())) {
            current = current.next;
            pos++;
        }

        if (current != null && key.equals(current.getData())) {
            return pos;
        } else {
            return -1;
        }
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

    /**
     *
     * @return the total size of the LinkedList
     */
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
