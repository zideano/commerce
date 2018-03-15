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

    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>(str.length());
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

}
