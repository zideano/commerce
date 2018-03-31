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

        Tree left = findFirstCommonAncestor(root.left, node1, node2);
        Tree right = findFirstCommonAncestor(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        } else {
            if (left == null) {
                return right;
            } else {
                return left;
            }
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
