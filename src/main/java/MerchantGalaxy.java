import service.GalaxyMerchantConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MerchantGalaxy implements GalaxyMerchantConverter {
    private static final Logger LOGGER = Logger.getLogger(MerchantGalaxy.class.getName());
    private Map<String, Integer> converter = new LinkedHashMap<>();
    private Map<String, String> transactions = new HashMap<>();

    {
        converter.put("I", 1);
        converter.put("V", 5);
        converter.put("X", 10);
        converter.put("L", 50);
        converter.put("C", 100);
        converter.put("D", 500);
        converter.put("M", 1000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MerchantGalaxy that = (MerchantGalaxy) o;
        return Objects.equals(converter, that.converter) &&
                Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(converter, transactions);
    }

    public void galaxyMerchantConverter(String filename) throws IOException {
        Path path = Paths.get(filename);
        String pattern_1 = "how much is";
        String pattern_2 = "how many credits";
        String pattern_3 = "";
        Map<List<String>, Integer> totalCredits = new LinkedHashMap<>();
        Map<List<String>, Integer> newItemCost = new HashMap<>();


        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Pattern mainPattern = Pattern.compile("(\\w+) is (\\w+)");
                Pattern wordListBefore = Pattern.compile("([\\w\\s]+) is");
                Pattern wordListAfter = Pattern.compile("is ([\\w\\s]+)");

                // Find the main pattern to check for
                Matcher matcher = mainPattern.matcher(line);

                while (matcher.find()) {
                    if (findRomanNumeral(matcher)) {
                       String[] temp = matcher.group().split("\\s+");
                       transactions.put(temp[0], temp[2]);
                    } else if (findItemsList(matcher)) {
                        Integer number = Integer.valueOf(matcher.group().split("\\s+")[2]);
                        Matcher m = wordListBefore.matcher(line);
                        List<String> stringList = new LinkedList<>();

                        while (m.find()) {
                            String[] words = m.group(1).split("\\s+");
                            Map<String, Integer> hmap = new HashMap<>();
                            Integer total = 0;

                            wordFrequency(stringList, words, hmap);

                            for (Map.Entry wordList : hmap.entrySet()) {
                                for (Map.Entry word : converter.entrySet()) {
                                    if (wordList.equals((String) word.getKey())) {
                                        total = total + ((Integer) word.getValue() * (Integer) wordList.getValue());
                                    } else {

                                    }
                                }
                            }

                            System.out.println(hmap.toString());
                            System.out.println("Here is my word list: " + words[0] + " " + words[1] + " " + words[2]);
                        }

                        totalCredits.put(stringList, number);
                        System.out.println("Found a number -> " + number);
                    } else if (findCostForItems(matcher)) {
                        Matcher m = wordListAfter.matcher(line);
                        List<String> stringList = new LinkedList<>();

                        while (m.find()) {
                            String[] words = m.group(1).split("\\s+");


                            for (String str : words) {
                                stringList.add(str);
                            }

                            System.out.println(stringList.toString());
                        }


                        System.out.println("Found a cost list");
                    } else if (findHowManyCredits(matcher)) {
                        System.out.println("Found some credits");
                    } else {
                        System.out.println("I have no idea what you are talking about");
                    }

                    System.out.println(matcher.group());
                }

            }

            System.out.println(transactions.toString());
            System.out.println(converter.toString());
            System.out.println(totalCredits.toString());
        }
    }

    private void wordFrequency(List<String> stringList, String[] words, Map<String, Integer> hmap) {
        for (int i = 0; i < words.length; i++) {
            Integer c = hmap.get(words[i]);

            if (hmap.get(words[i]) == null) {
                hmap.put(words[i], 1);
            } else {
                hmap.put(words[i], ++c);
            }

            stringList.add(words[i]);
        }
    }

    private boolean findHowManyCredits(Matcher matcher) {
        String pattern = "credits is";

        if (matcher.group().toLowerCase().contains(pattern)) {
            return true;
        }
        return false;
    }

    private boolean findItemsList(Matcher matcher) {
        if (matcher.group().matches("(\\w+) is (\\d+)")) {
            return true;
        }
        return false;
    }

    private boolean findCostForItems(Matcher matcher) {
        String pattern = "much is";

        if (matcher.group().toLowerCase().contains(pattern)) {
            return true;
        }
        return false;
    }


    private boolean findRomanNumeral(Matcher matcher) {
        if (matcher.group().matches("(\\w+) is [IVXLCDM]")) {
            return true;
        }
        return false;
    }

    private void totalAmountOfItems() {

    }

    private void cost() {

    }

    public void printResults() {

    }
}
