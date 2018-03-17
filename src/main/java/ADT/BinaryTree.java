package ADT;

import java.util.Objects;

/**
 * Generic type binary tree root structure, which is composed
 * of a single root node, and where each nodes have no more
 * than 2 child nodes and a final node called a leaf node when
 * there is no further child nodes (sub-nodes).
 *
 * Order: left node is always less than the right nodes
 *
 * @param <T>
 */
public class BinaryTree<T> {
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private T root;

    public BinaryTree(T root) {
        this.root = root;
    }

    /**
     * Add new root to our binary tree
     *
     * @param data
     */
    public void insert(T data) {
        if (data instanceof Integer) {
            isInteger((Integer) data);
        } else if (data instanceof String) {
            isString((String) data);
        } else if (data instanceof Character) {
            isCharacter((Character) data);
        } else if (data instanceof Comparable) {
            isObject((Comparable) data);
        } else {
            throw new RuntimeException("Unsupported root type -> " + data.getClass().getName());
        }
    }

    /**
     * This method checks for the respective root type
     * then search the binary tree for the root.
     *
     * @param data to be searched for in the binary tree
     * @return true if root is found otherwise return false;
     */
    public boolean find(T data) {
        if (data instanceof Integer) {
            return findInteger((Integer) data);
        } else if (data instanceof String) {
           return findString((String) data);
        } else if (data instanceof Character) {
            return findCharacter((Character) data);
        } else if (data instanceof Comparable) {
           return findComparable((Comparable) data);
        } else {
            throw new RuntimeException("Unsupported root type -> " + data.getClass().getName());
        }
    }

    private void isInteger(Integer val) {
        if (val < (Integer) this.root) {
            if (left == null) {
                left = new BinaryTree<>((T) val);
            } else {
                left.isInteger(val);
            }
        } else if (val == this.root) {
            System.out.println("The integer -> " + val + " is already in the tree ");
        } else {
            if (right == null) {
                right = new BinaryTree<>((T) val);
            } else {
                right.isInteger(val);
            }
        }
    }

    private void isString(String val) {
        int res = val.compareTo((String) this.root);

        if (res < 0) {
            if (left == null) {
                left = new BinaryTree<>((T) val);
            } else {
                left.isString(val);
            }
        } else if (res == 0){
            System.out.println("The string -> " + val + " is already in the tree ");
            return;
        } else {
            if (right == null) {
                right = new BinaryTree<>((T) val);
            } else {
                right.isString(val);
            }
        }
    }

    private void isCharacter(Character val) {
        int res = val.compareTo((Character) this.root);

        if (res < 0) {
            if (left == null) {
                left = new BinaryTree<>((T) val);
            } else {
                left.isCharacter(val);
            }
        } else if (res == 0) {
            System.out.println("The character -> " + val + " is already in the tree ");
            return;
        } else {
            if (right == null) {
                right = new BinaryTree<>((T) val);
            } else {
                right.isCharacter(val);
            }
        }
    }

    private void isObject(Comparable val) {
        int res = val.compareTo((Comparable) this.root);

        if (res < 0) {
            if (left == null) {
                left = new BinaryTree<>((T) val);
            } else {
                left.isObject(val);
            }
        } else if (res == 0) {
            System.out.println("The comparable object -> " + val + " is already in the tree ");
            return;
        } else {
            if (right == null) {
                right = new BinaryTree<>((T) val);
            } else {
                right.isObject(val);
            }
        }
    }

    private boolean findInteger(Integer val) {
        if (val == this.root) {
            return true;
        } else if (val < (Integer) this.root) {
            if (left == null) {
                return false;
            } else {
                return left.findInteger(val);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.findInteger(val);
            }
        }
    }

    private boolean findString(String val) {
        int res = val.compareTo((String) this.root);

        if (res == 0) {
            return true;
        } else if (res < 0){
            if (left == null) {
                return false;
            } else {
                return left.findString(val);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.findString(val);
            }
        }
    }

    private boolean findCharacter(Character val) {
        int res = val.compareTo((Character) this.root);

        if (res == 0 ) {
          return true;
        } else if (res < 0) {
            if (left == null) {
                return false;
            } else {
                return left.findCharacter(val);
            }
        } else {
            if (right == null) {
                return false;
            } else {
               return right.findCharacter(val);
            }
        }
    }

    private boolean findComparable(Comparable val) {
        int res = val.compareTo(this.root);

        if (res == 0) {
            return true;
        } else if (res < 0) {
            if (left == null) {
                return false;
            } else {
                return left.findComparable(val);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.findComparable(val);
            }
        }
    }

    /**
     * Traverse the binary tree using the inorder traversal
     * procedure, traveling from the left node, root node to
     * the right node.
     *
     *              (root)
     *              /    \
     *             /      \
     *            /        \
     *           /          \
     *         (left)       (right)
     */
    public void traverse() {
        if (left != null) {
            left.traverse();
        }

        System.out.println(root);

        if (right != null) {
            right.traverse();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTree<?> that = (BinaryTree<?>) o;
        return Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {

        return Objects.hash(left, right, root);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "left=" + left +
                ", right=" + right +
                ", root=" + root +
                '}';
    }
}
