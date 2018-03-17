package ADT;

import java.util.Arrays;

/**
 * Generic stack data structure that is capable to deal
 * with any object data type
 * @param <T>
 */
public class Stack<T> {
    private T[] arr;
    private int index;
    private int maxSize;

    public Stack(int size) {
        arr = (T[]) new Object[size];
        index = 0;
        this.maxSize = size;
    }

    /**
     * The push instance method is used to push data
     * onto the top of the stack in the LIFO order
     * where the last element added will be the first
     * one that gets pop off the stack.
     * @param data
     */
    public void push(T data) {
        if (!isFull()) {
            arr[index++] = data;
        } else {
            throw new  RuntimeException("The stack is full");
        }
    }

    /**
     * This method pops off the lastest data added onto
     * the stack in the last-in-first-out (LIFO) order.
     *
     * @return the last element placed onto the stack.
     */
    public T pop() {
        T temp;

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
        return "ADT.Stack{" +
                "arr=" + Arrays.toString(arr) +
                ", index=" + index +
                '}';
    }
}
