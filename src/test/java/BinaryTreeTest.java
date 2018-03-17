import ADT.BinaryTree;
import ADT.Queue;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBinaryTreeWithInteger() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(6);
        binaryTree.insert(2);
        binaryTree.insert(7);
        binaryTree.insert(8);
        binaryTree.insert(4);

        boolean eight = binaryTree.find(8);
        boolean six = binaryTree.find(6);
        boolean two = binaryTree.find(2);
        boolean seven = binaryTree.find(7);
        boolean four = binaryTree.find(4);

        boolean wrong = binaryTree.find(10);

        Assert.assertTrue(eight);
        Assert.assertTrue(two);
        Assert.assertTrue(seven);
        Assert.assertTrue(six);
        Assert.assertTrue(four);
        Assert.assertFalse(wrong);
    }

    @Test
    public void testBinaryTreeWithString() {
        BinaryTree<String> binaryTree = new BinaryTree<>("tree");
        binaryTree.insert("data");
        binaryTree.insert("binary");
        binaryTree.insert("amour");
        binaryTree.insert("random");

        boolean rand = binaryTree.find("random");
        boolean amour = binaryTree.find("amour");
        boolean binary = binaryTree.find("binary");
        boolean data = binaryTree.find("data");
        boolean tree = binaryTree.find("tree");

        boolean wrong = binaryTree.find("wrong");

        Assert.assertTrue(rand);
        Assert.assertTrue(binary);
        Assert.assertTrue(data);
        Assert.assertTrue(amour);
        Assert.assertTrue(tree);
        Assert.assertFalse(wrong);
    }

    @Test
    public void testBinaryTreWithCharacter() {
        BinaryTree<Character> binaryTree = new BinaryTree<>('c');
        binaryTree.insert('k');
        binaryTree.insert('z');
        binaryTree.insert('p');
        binaryTree.insert('w');

        boolean c = binaryTree.find('c');
        boolean k = binaryTree.find('k');
        boolean z = binaryTree.find('z');
        boolean p = binaryTree.find('p');
        boolean w = binaryTree.find('w');

        boolean wrong = binaryTree.find('a');

        Assert.assertTrue(c);
        Assert.assertTrue(z);
        Assert.assertTrue(p);
        Assert.assertTrue(k);
        Assert.assertTrue(w);
        Assert.assertFalse(wrong);
    }

    @Test
    public void testBinaryTreeTraversal() {
        BinaryTree<Character> binaryTree = new BinaryTree<>('c');
        binaryTree.insert('k');
        binaryTree.insert('z');
        binaryTree.insert('p');
        binaryTree.insert('w');

        BinaryTree<Character> binaryTree2 = new BinaryTree<>('c');
        binaryTree2.insert('k');
        binaryTree2.insert('z');
        binaryTree2.insert('p');
        binaryTree2.insert('w');

        BinaryTree<Character> binaryTree3 = new BinaryTree<>('c');
        binaryTree3.insert('k');
        binaryTree3.insert('z');
        binaryTree3.insert('q');
        binaryTree3.insert('w');

        String result = binaryTree.toString();
        String result2 = binaryTree2.toString();
        String result3 = binaryTree3.toString();

        Assert.assertEquals(result, result2);
        Assert.assertNotEquals(result, result3);
        Assert.assertNotEquals(result2, result3);
    }

    @Test(expected = RuntimeException.class)
    public void testForExceptionThrownWithWrongDataType() {
        Queue<Integer> queue = new Queue<>(2);
        queue.enqueue(3);
        BinaryTree<Queue> binaryTree = new BinaryTree<>(new Queue(2));

        binaryTree.insert(queue);
        binaryTree.find(queue);
    }
}
