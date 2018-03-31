package ADT;

import java.util.Objects;

public class Tree {
    public Tree left;
    public Tree right;
    private int value;
    private int size;

    public Tree(int root) {
        this.value = root;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void insert(int data) {
        if (data < this.value) {
            if (left == null) {
                left = new Tree(data);
                size++;
            } else {
                size++;
                left.insert(data);
            }
        } else if (data == this.value) {
            System.out.println(data + " already inside the Tree");
        } else {
            if (right == null) {
                right = new Tree(data);
                size++;
            } else {
                size++;
                right.insert(data);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(left, tree.left) &&
                Objects.equals(right, tree.right) &&
                Objects.equals(value, tree.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(left, right, value);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }

    public void print() {
        if (left != null ) {
            left.print();
        }

        System.out.println(value);

        if (right != null) {
            right.print();
        }
    }

    public int getSize() {
        return size;
    }
}
