package MultillevelCache.strategy;

import java.util.HashMap;

import MultillevelCache.level.Level;
import MultillevelCache.pair.Pair;

public abstract class Strategy {
    public abstract Pair add(Pair pair);
    public abstract String read(String key);
    public abstract Level getNextLevel(int size);
}
