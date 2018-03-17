package ADT;

import java.util.Arrays;

/**
 * Generic queue class is able to create a queue of elements
 * with any object data types, creating elements in the order
 * first-in-first-out (FIFO).
 * @param <T>
 */
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

    /**
     * Enqueue data into the queue in FIFO manner
     * @param data is added to the front of queue
     */
    public void enqueue(T data) {
        if (!isFull()) {
            rear++;
            arr[rear] = data;
            index++;
        } else {
            throw new RuntimeException("ADT.Queue is full");
        }
    }

    /**
     * The dequeue method is responsible for de-queueing
     * elements from the front of the queue.
     *
     * @return the element at the head of the queue.
     */
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

    /**
     * The peek method will print a complete view
     * of the current queue.
     */
    public void peek() {
        System.out.print("[ ");

        for (T anArr : arr) {
            System.out.print(anArr + " ");
        }

        System.out.print("]");
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
