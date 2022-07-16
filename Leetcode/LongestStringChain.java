import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/longest-string-chain/

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        for(String word: words) {
            map.put(word, 1);
            for(int i=0; i<word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String prev = sb.deleteCharAt(i).toString();
                if(map.containsKey(prev) && map.get(prev) + 1 > map.get(word)) {
                    map.put(word, map.get(prev) + 1);
                }
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }
}
