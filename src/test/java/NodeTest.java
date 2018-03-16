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
    }
}
