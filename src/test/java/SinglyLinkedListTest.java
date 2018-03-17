import ADT.Node;
import ADT.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void testListIsEmpty() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>(null);
        boolean result = singlyLinkedList.isEmpty();
        Assert.assertTrue(result);
    }

    @Test
    public void testInsertMethods() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>(new Node<>(1));
        singlyLinkedList.insert(2);
        singlyLinkedList.insertFirst(3);

        Assert.assertEquals(3, singlyLinkedList.size());
        Assert.assertFalse(singlyLinkedList.isEmpty());

        singlyLinkedList.insertAfter(2, 4);

        Assert.assertTrue(singlyLinkedList.size() == 4);
    }

    @Test
    public void testDeleteMethods() {
        SinglyLinkedList<Character> singlyLinkedList = new SinglyLinkedList<>(new Node<>('c'));
        singlyLinkedList.insert('d');
        singlyLinkedList.insert('e');

        Node<Character> characterNode = singlyLinkedList.deleteLast();
        Assert.assertTrue(singlyLinkedList.size() == 2);
        Assert.assertEquals('e', characterNode.toString().charAt(0));

        Node<Character> characterNode2 = singlyLinkedList.delete('d');
        Assert.assertEquals('d', characterNode2.toString().charAt(0));
    }

    @Test
    public void testSearchMethod() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>(new Node<>("set"));
        singlyLinkedList.insert("link");
        singlyLinkedList.insert("queue");
        singlyLinkedList.insert("stack");

        int index = singlyLinkedList.search("queue");

        Assert.assertTrue(index == 2);

        int index2 = singlyLinkedList.search("false");

        Assert.assertTrue(index2 == -1);
    }
}
