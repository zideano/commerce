import java.util.Arrays;

public class Stack<T> {
    private T[] arr;
    private int index;
    private int maxSize;

    Stack(int size) {
        arr = (T[]) new Object[size];
        index = 0;
        this.maxSize = size;
    }

    public void push(T data) {
        if (!isFull()) {
            arr[index++] = data;
        } else {
            throw new  RuntimeException("The stack is full");
        }
    }

    public T pop() {
        T temp = null;

        if (!isEmpty()) {
            temp = arr[--index];
        } else {
            throw new  RuntimeException("The stack is empty");
        }

        return temp;
    }

    public boolean isFull() {
        return index == arr.length;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int capacity() {
        return maxSize;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                ", index=" + index +
                '}';
    }
}
