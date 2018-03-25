package ADT;

/**
 * Generic Node class accepts any type as parameter
 * and create a node with a link to the next node
 * @param <T>
 */
    public class Node<T> {
        private T data;
        public Node next;

        public Node(T data) {
            this.data = data;
        }

        /**
         * This non-instance method takes a node as input and iterate
         * over all the nodes in this link of nodes, then print the
         * total nodes in the link.
         *
         * @param node list
         * @return the total size of the LinkedList
         */
        public static int size(Node<?> node) {
            int length = 0;

            Node<?> current = node;

            while (current != null) {
                current = current.next;
                length++;
            }

            return length;
        }

        public void display() {
            System.out.print(data);
        }

        @Override
        public String toString() {
            String str = " -> ";
            str += data;
            return str;
        }

        public T getData() {
            return data;
        }
    }
