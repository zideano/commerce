package sorting;

import ADT.Stack;

public class SortingUtils {

    private SortingUtils() {
        throw new AssertionError("Malicious code");
    }

    /**
     * This takes an object of type Comparable, with a key
     * of type Comparable as well; otherwise, an IllegalArgumentException is thrown.
     *
     * @param arr the array to be searched
     * @param key the object to search for
     * @return the index of the key or -1
     */
    public static int binarySearch(Object[] arr, Object key) {

        int len = arr.length - 1;
        int low = 0;
        int high = len;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key instanceof Comparable) {
                int index = ((Comparable) key).compareTo(arr[mid]);

                if (index < 0) {
                    high = mid - 1;
                } else if (index == 0) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                throw new IllegalArgumentException("Object " + key + " needs to be of type " +
                        "Comparable");
            }
        }

        return -1;
    }

    /**
     * This takes an int array and int key. Throws IllegalStateException
     * if the array is empty.
     *
     * @param arr the array to be searched
     * @param key the object to search for
     * @return the index of the key or -1
     */
    public static int binarySearch(int[] arr, int key) {

        int len = arr.length;
        int low = 0;
        int high = len;

        if (len == 0) {
            throw new IllegalStateException("Array storage insufficient");
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key == arr[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Insertion sort method to sort an unsorted array
     * O(n^2).
     *
     * @param arr unsorted array
     * @return the sorted array
     */
    public static int[] insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }

            arr[i + 1] = key;
        }

        return arr;
    }

    /**
     * Bubble sort method to sort an unsorted array
     * O(n^2)
     *
     * @param arr unsorted array
     * @return the sorted array
     */
    public static int[] bubbleSort(int[] arr) {
        boolean sorted = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    /**
     * This method takes an original input string
     * then use a Stack data structure to reverse
     * the input string.
     *
     * @param str is the original string
     * @return reversed string
     */
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>(str.length());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }

}
