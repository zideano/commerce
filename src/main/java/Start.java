import ADT.Node;
import ADT.Queue;
import ADT.Stack;

public class Start {
    public static void main(String[] args) {
//        MerchantGalaxy merchantGalaxy = new MerchantGalaxy();
//
//        String filename = "galaxy_itmes.txt";
//        try {
//            merchantGalaxy.galaxyMerchantConverter(filename);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Queue<String> queue = new Queue<>(6);
        queue.enqueue("I");
        queue.enqueue("will");
        queue.enqueue("be");
        queue.enqueue("a");
        queue.enqueue("super");
        queue.enqueue("hero");

        System.out.println("Peek front -> " + queue.peekFront());
        System.out.println("Peek front -> " + queue.peekRear());

        System.out.print("Peek full queue -> ");
        queue.peek();
        System.out.println();


        Node<Integer> nodeA = new Node<>(4);
        Node<Integer> nodeB = new Node<>(3);
        Node<Integer> nodeC = new Node<>(7);
        Node<Integer> nodeD = new Node<>(8);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        System.out.println(Node.size(nodeA));
        System.out.println(Node.size(nodeB));

        String original = "Hello";
        System.out.println("Original string -> " + original);
        System.out.println("Reverse string -> " + reverseString(original));

    }

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
