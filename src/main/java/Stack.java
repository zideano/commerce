import java.util.Arrays;

public class Stack<T> {
    private T[] arr;
    private int index;

    Stack(int size) {
        arr = (T[]) new Object[size];
        index = 0;
    }

    public void push(T data) {
        if (!isFull()) {
            arr[index++] = data;
        } else {
            System.out.println("The stack is full");
        }
    }

    public T pop() {
        T temp = null;

        if (!isEmpty()) {
            temp = arr[--index];
        } else {
            System.out.println("The stack is empty");
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

    @Override
    public String toString() {
        return "Stack{" +
                "arr=" + Arrays.toString(arr) +
                ", index=" + index +
                '}';
    }
}
