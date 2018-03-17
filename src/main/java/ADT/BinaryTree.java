package ADT;

public class BinaryTree<T> {
    private Node<T> left;
    private Node<T> right;
    private T data;

    public BinaryTree(T data) {
        this.data = data;
    }
}
