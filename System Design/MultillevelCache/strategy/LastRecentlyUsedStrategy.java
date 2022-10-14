package MultillevelCache.strategy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

import MultillevelCache.level.Level;
import MultillevelCache.pair.Pair;

public class LastRecentlyUsedStrategy extends Strategy {

    HashMap<String, String> pairs;
    HashMap<String, Integer> counts;
    HashMap<Integer, LinkedHashSet<String>> lists;
    int maxSize;
    int min = -1;

    public LastRecentlyUsedStrategy(int maxSize) {
        this.maxSize = maxSize;
        pairs = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
    }

    @Override
    public Pair add(Pair pair) {
        String key = pair.getKey(), value = pair.getValue();
        if(pairs.containsKey(key)) {
            pairs.put(key, value);
            read(key);
            return null;
        }
        Pair evicted = null;
        if(pairs.size() >= maxSize) {
            String evictedKey = lists.get(min).iterator().next();
            lists.get(min).remove(evictedKey);
            counts.remove(evictedKey);
            evicted = new Pair(evictedKey, pairs.get(evictedKey));
            pairs.remove(evictedKey);
        }
        pairs.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
        return evicted;
    }

    @Override
    public String read(String key) {
        if(!pairs.containsKey(key)) {
            if(pairs.size() != maxSize) throw new NoSuchElementException();
            else return null;
        }
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count == min && lists.get(count).size() == 0) 
            min++;
        if(!lists.containsKey(count+1)) {
            lists.put(count+1, new LinkedHashSet<>());
        }
        lists.get(count+1).add(key);
        return pairs.get(key);
    }

    @Override
    public Level getNextLevel(int size) {
        Strategy newStrategy = new LastRecentlyUsedStrategy(size);
        return new Level(newStrategy, size, false);
    }
}
