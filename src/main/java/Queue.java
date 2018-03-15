import java.util.Arrays;

public class Queue<T> {
    private T[] arr;
    private int index;
    private int front;
    private int rear;

    public Queue(int size) {
        arr = (T[]) new Object[size];
        index = 0;
        rear = -1;
        front = 0;
    }

    public void enqueue(T data) {
        if (!isFull()) {
            rear++;
            arr[rear] = data;
            index++;
        } else {
            throw new RuntimeException("Queue is full");
        }
    }

    public T dequeue() {
        T temp;

        if (!isEmpty()) {
            temp = arr[front];
            front++;

            if (front == arr.length) {
                front = 0;
            }

            index--;
        } else {
            throw new RuntimeException("Queue is empty");
        }

        return temp;
    }

    public T peekFront() {
        return arr[front];
    }

    public T peekRear() {
        return arr[rear];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == arr.length;
    }

    public void peek() {
        System.out.printf("[ ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.printf("]");
    }

    @Override
    public String toString() {
        return "Queue{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
