//https://leetcode.com/problems/permutation-in-string/
import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if(n1==0||n2==0||n2<n1) return false;
        if(n1==1){
            char ch = s1.charAt(0);
            for(int i=0; i<n2; i++){
                if(s2.charAt(i)==ch) return true;
            }
            return false;
        }
        int[] pat = new int[26];
        for(int i=0; i<n1; i++){
            pat[s1.charAt(i)-'a']++;
        }
        int[] che = new int[26];
        for(int i=0; i<=n2; i++){
            if(Arrays.equals(pat, che)) return true;
            if(i<n1){
                che[s2.charAt(i)-'a']++;
            }else if(i<n2){
                che[s2.charAt(i-n1)-'a']--;
                che[s2.charAt(i)-'a']++;
            }
        }
        return false;
    }
}
