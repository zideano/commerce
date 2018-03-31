package ADT;

public class StringManipulation {
    public static class Tree {
        private int data;

    }

    public static void main(String[] args) {
        String val = "ThIs is p";

        String result = StringManipulation.run(val);
        System.out.println(result);
    }

    public static String run(String p) {

        StringBuilder reverseString = new StringBuilder(p);
        StringBuilder temp = new StringBuilder();
        String sep = "::";
        String combined_queries = "";

        // Insert "-" between all words
        String separatedString = p.replaceAll(" ", "-");

        // Place the string "pv" before all vowels
        String vowelString = p.replaceAll("(?i)(a|e|i|o|u|A|E|I|O|U)", "pv$1");

        int numVowels = p.length() - p.replaceAll("(a|e|i|o|u|A|E|I|O|U)", "").length();

        // Convert lowercase to uppercase and vis-a-vis
        for (int i = 0; i < reverseString.length(); i++) {
            char c = p.charAt(i);
            if (Character.isLowerCase(c)) {
                temp.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                temp.append(Character.toLowerCase(c));
            } else {
                temp.append(c);
            }
        }

        String[] str = temp.toString().split(" ");
        StringBuilder reverse = new StringBuilder();
        // Reverse the sentence
        for (int i = str.length-1; i >= 0; i--) {
            reverse.append(str[i] + " ");
        }

        StringBuilder separatedCase = changeToLowerCase(separatedString);

        combined_queries = numVowels + " " + (p.replaceAll(" ", "").length() - numVowels) + sep + reverse.toString().trim() + sep +
                separatedCase.toString() + sep + vowelString;
        return combined_queries;
    }

    private static StringBuilder changeToLowerCase(String separatedString) {
        String[] tokens = separatedString.split("(?=\\W)");
        StringBuilder b = new StringBuilder();
        for(String t : tokens) {
            if(t.length() == 0) continue;
            b.append(t.substring(0,1).toUpperCase());
            b.append(t.substring(1).toLowerCase());
        }
        return b;
    }


}
