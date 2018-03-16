import ADT.Node;
import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void testNodeClass() {
        Node<Integer> node = new Node<>(1);

        Assert.assertTrue(Node.size(node) == 1);

        Integer data = node.getData();
        Assert.assertTrue(data == 1);

        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);

        node.next = node2;
        node2.next = node3;

        Assert.assertEquals(3, Node.size(node));
    }
}
