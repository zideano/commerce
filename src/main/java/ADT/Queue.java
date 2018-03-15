package ADT;

import java.util.Arrays;

public class Queue<T> {
    private T[] arr;
    private int index;
    private int front;
    private int rear;
    private int maxSize;

    public Queue(int size) {
        arr = (T[]) new Object[size];
        index = 0;
        rear = -1;
        front = 0;
        this.maxSize = size;
    }

    public void enqueue(T data) {
        if (!isFull()) {
            rear++;
            arr[rear] = data;
            index++;
        } else {
            throw new RuntimeException("ADT.Queue is full");
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
            throw new RuntimeException("ADT.Queue is empty");
        }

        return temp;
    }

    public T peekFront() {
        return arr[front];
    }

    public T peekRear() {
        if (rear == -1) {
            throw new RuntimeException("Rear index is negative");
        }

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

        for (T anArr : arr) {
            System.out.print(anArr + " ");
        }

        System.out.printf("]");
    }

    public int capacity() {
        return maxSize;
    }

    public int size() {
        return index;
    }

    @Override
    public String toString() {
        return "ADT.Queue{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
