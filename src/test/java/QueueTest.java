import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test(expected = RuntimeException.class)
    public void testQueueForCorrectBehavior() {
        Queue<Integer> queueOfIntegers = new Queue<>(3);

        Assert.assertEquals(null, queueOfIntegers.peekFront());
        Assert.assertEquals(null, queueOfIntegers.peekRear());

        queueOfIntegers.enqueue(2);
        queueOfIntegers.enqueue(3);

        Assert.assertEquals(2, queueOfIntegers.size());
        Assert.assertEquals(3, queueOfIntegers.capacity());

        Assert.assertEquals(2, java.util.Optional.of(queueOfIntegers.peekFront()));
        Assert.assertEquals(3, java.util.Optional.ofNullable(queueOfIntegers.peekRear()));

        Assert.assertFalse(queueOfIntegers.isEmpty());
        Assert.assertFalse(queueOfIntegers.isFull());

        Assert.assertEquals(2, java.util.Optional.ofNullable(queueOfIntegers.dequeue()));
        Assert.assertTrue(queueOfIntegers.size() == 1);

        queueOfIntegers.enqueue(4);
        queueOfIntegers.enqueue(5);
        queueOfIntegers.enqueue(6); // Should throw an exception
    }
}
