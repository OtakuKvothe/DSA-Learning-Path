import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while(l <= r && r < n) {
            if(set.contains(s.charAt(r))) {
                while(l < r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            } else {
                set.add(s.charAt(r));
                res = Math.max(res, r-l+1);
                r++;
            }
        }
        return res;
    }
}
