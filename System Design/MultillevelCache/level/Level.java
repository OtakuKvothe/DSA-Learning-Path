package MultillevelCache.level;

import java.util.HashMap;
import java.util.NoSuchElementException;

import MultillevelCache.pair.Pair;
import MultillevelCache.strategy.Strategy;

public class Level {
    
    HashMap<String, String> pairs;
    Level nextLevel;
    int maxSize;
    Strategy strategy;
    boolean isBaseLevel;

    public Level(Strategy strategy, int maxSize, boolean isBaseLevel) {
        this.strategy = strategy;
        this.maxSize = maxSize;
    }

    public HashMap<String, String> getPairs() {
        return pairs;
    }

    public void setPairs(HashMap<String, String> pairs) {
        this.pairs = pairs;
    }

    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }

    public void add(String key, String value) {
        Pair pair = new Pair(key, value);
        Pair res = strategy.add(pair);
        if(res != null) {
            getNextLevel().add(res.getKey(), res.getValue());
        }
    }

    public String read(String key) {
        try {
            String res = strategy.read(key);
            if(res == null) {
                return getNextLevel().read(key);
            } else return res;
        } catch (NoSuchElementException e) {
            return "Key Does not exist!!";
        }
    }

    private Level getNextLevel() {
        if(nextLevel == null) {
            nextLevel = strategy.getNextLevel(maxSize);
        }
        return nextLevel;
    }
}
