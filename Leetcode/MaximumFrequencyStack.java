//https://leetcode.com/problems/maximum-frequency-stack
import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();
    int max = 0;
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        max = Math.max(max, f);
        if(!map.containsKey(f)) map.put(f, new Stack<Integer>());
        map.get(f).add(val);
    }
    
    public int pop() {
        if(map.isEmpty()||map.get(max).isEmpty()) throw new NullPointerException();
        int res = map.get(max).pop();
        freq.put(res, max-1);
        if(map.get(max).isEmpty()) max--;
        return res;
    }
}
