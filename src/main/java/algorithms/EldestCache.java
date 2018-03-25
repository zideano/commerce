package algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class EldestCache extends LinkedHashMap {
    private static final int MAX_SIZE = 5;

    @Override
    protected boolean removeEldestEntry(Map.Entry entry) {
        return size() > MAX_SIZE;
    }


    public static void main(String[] args) {
        EldestCache cache = new EldestCache();

        cache.put(0, "T");
        cache.put(1, "e");
        cache.put(2, "s");
        cache.put(3, "t");
        cache.put(4, "i");

        System.out.println(cache);

        cache.put(5, "n");
        cache.put(6, "g");

        System.out.println(cache);
    }
}
