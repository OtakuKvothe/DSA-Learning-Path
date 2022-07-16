import java.util.Arrays;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

public class MinumumDeletions {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        for(char c: s.toCharArray()) {
            counts[c-'a']++;
        }
        Arrays.sort(counts); //nlogn
        int res = 0;
        for(int i=25; i>0; i--) {
            while(counts[i] <= counts[i-1] && counts[i-1] > 0) {
                counts[i-1]--;
                res++;
            }
        }
        return res;
    }
}
