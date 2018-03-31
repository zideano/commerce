import ADT.Tree;
import leetcode_algorithm.KthSmallestElementInBST;
import org.junit.Assert;
import org.junit.Test;

public class KthSmallestElementInBSTTest {

    @Test
    public void kthSmallestTest() {
        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();

        /*
         *      root =   8
         *            /    \
         *           6      10
         *          / \    /  \
         *         5  7   9    10
         *
         *     The 5th smallest element in the BST is 9 using in-order traversal
         */
        Tree tree = new Tree(8);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);

        int kthSmallest = kthSmallestElementInBST.kthSmallest(tree, 5);
        int kthSmallest2 = kthSmallestElementInBST.kthSmallest(tree, 4);
        int kthSmallest3 = kthSmallestElementInBST.kthSmallest(tree, 6);

        Assert.assertEquals(9, kthSmallest);
        Assert.assertEquals(8, kthSmallest2);
        Assert.assertEquals(10, kthSmallest3);
    }
}
