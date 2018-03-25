import ADT.Tree;
import algorithms.CommonNodeAncestor;
import org.junit.Assert;
import org.junit.Test;

public class CommonNodeAncestorTest {

    @Test
    public void testFindFirstCommonAncestorWithInteger() {
        CommonNodeAncestor nodeAncestor = new CommonNodeAncestor();
        Tree tree = new Tree(6);
        tree.insert(4);
        tree.insert(17);
        tree.insert(2);
        tree.insert(5);
        tree.insert(7);
        tree.insert(3);
        tree.insert(8);
        tree.insert(19);
        tree.insert(18);

        Tree fcn1 = nodeAncestor.findFirstCommonAncestor(tree, 4, 17);
        Tree fcn2 = nodeAncestor.findFirstCommonAncestor(tree, 2, 7);
        Tree fcn3 = nodeAncestor.findFirstCommonAncestor(tree, 7, 19);
        Tree fcn4 = nodeAncestor.findFirstCommonAncestor(tree, 4, 5);
        Tree fcn5 = nodeAncestor.findFirstCommonAncestor(tree, 3, 5);
        Tree fcn6 = nodeAncestor.findFirstCommonAncestor(tree, 2, 19);

        Assert.assertTrue(fcn1.getValue() == 6);
        Assert.assertTrue(fcn2.getValue() == 6);
        Assert.assertTrue(fcn3.getValue() == 17);

        Assert.assertEquals(4, fcn4.getValue());
        Assert.assertEquals(4, fcn5.getValue());
        Assert.assertEquals(6, fcn6.getValue());

    }

    @Test
    public void testFindFirstCommonAncestorWithTrees() {
        CommonNodeAncestor nodeAncestor = new CommonNodeAncestor();
        Tree tree = new Tree(6);
        tree.insert(4);
        tree.insert(17);
        tree.insert(2);
        tree.insert(5);
        tree.insert(7);
        tree.insert(3);
        tree.insert(8);
        tree.insert(19);
        tree.insert(18);

        Tree tree1 = new Tree(4);
        Tree tree2 = new Tree(17);
        Tree tree3 = new Tree(2);
        Tree tree4 = new Tree(7);
        Tree tree5 = new Tree(7);
        Tree tree6 = new Tree(19);



        Tree fcn1 = nodeAncestor.findFirstCommonAncestor(tree, tree1, tree2);
        Tree fcn2 = nodeAncestor.findFirstCommonAncestor(tree, tree3, tree4);
        Tree fcn3 = nodeAncestor.findFirstCommonAncestor(tree, tree5, tree6);

        Assert.assertTrue(fcn1.getValue() == 6);
        Assert.assertTrue(fcn2.getValue() == 6);
        Assert.assertTrue(fcn3.getValue() == 17);


    }
}
