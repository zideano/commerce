package algorithms;

import ADT.Tree;

public class CommonNodeAncestor {

    public Tree findFirstCommonAncestor(Tree root, Tree node1, Tree node2) {
        if (root == null) {
            return null;
        }

        if (root == node1 || root == node2) {
            return root;
        }

        Tree left = findFirstCommonAncestor(root.getLeft(), node1, node2);
        Tree right = findFirstCommonAncestor(root.getRight(), node1, node2);

        if ((left == node1 && right == node2) || (left == node2 && right == node2)) {
            return root;
        }

        if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    public Tree findFirstCommonAncestor(Tree root, int a, int b) {
        if (root == null) {
            return null;
        }

        if (root.getValue() == a || root.getValue() == b) {
            return root;
        }

        if (root.getValue() > a && root.getValue() > b) {
            return findFirstCommonAncestor(root.getLeft(), a, b);
        } else if (root.getValue() < a && root.getValue() < b) {
            return findFirstCommonAncestor(root.getRight(), a, b);
        } else {
            return root;
        }
    }
}
