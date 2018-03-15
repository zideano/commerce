import ADT.Stack;
import org.junit.Assert;
import org.junit.Test;
public class StackTest {

    @Test
    public void testStackForCorrectBehavior() {
        Stack<String> stackOfStrings = new Stack<>(5);

        stackOfStrings.push("test");
        stackOfStrings.push("me");
        stackOfStrings.push("data");

        Assert.assertTrue("Should be true", stackOfStrings.capacity() == 5);
        Assert.assertEquals(3, stackOfStrings.size());

        String result = stackOfStrings.pop();
        Assert.assertEquals("data", result);
        Assert.assertEquals(2, stackOfStrings.size());
        Assert.assertFalse(stackOfStrings.isEmpty());
        Assert.assertFalse(stackOfStrings.isFull());

        stackOfStrings.push("still");
        stackOfStrings.push("going");
        stackOfStrings.push("full");

        Assert.assertTrue(stackOfStrings.isFull());
        Assert.assertEquals(5, stackOfStrings.size());
        Assert.assertEquals("full", stackOfStrings.pop());

    }

    @Test(expected = RuntimeException.class)
    public void testStackPopForExceptionThrown() {
        Stack<Integer> integerStack = new Stack<>(2);

        integerStack.pop();

        Assert.assertTrue(integerStack.isEmpty());
        Assert.assertFalse(integerStack.isFull());
    }

    @Test(expected = RuntimeException.class)
    public void testStackPushForExceptionThrown() {
        Stack<Integer> integerStack = new Stack<>(2);

        Assert.assertTrue(integerStack.isEmpty());
        Assert.assertFalse(integerStack.isFull());

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
    }
}
