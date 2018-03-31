package leetcode_algorithm;

import ADT.Tree;

public class KthSmallestElementInBST {
    private int current;
    private int kthSmallest;

    /**
     * Find the kth smallest element in a binary search tree
     *
     * @param root node of the BST
     * @param k 1 <= k <= BST length
     * @return kth smallest element
     */
    public int kthSmallest(Tree root, int k) {
        current = k;
        inorderTraversal(root);
        return kthSmallest;
    }

    private void inorderTraversal(Tree root) {
        if (root != null) {
            inorderTraversal(root.left);

            current--;

            if (current == 0) {
                kthSmallest = root.getValue();
                return;
            }

            inorderTraversal(root.right);
        }
    }

}
