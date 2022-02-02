//https://leetcode.com/problems/find-all-anagrams-in-a-string/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sl=s.length(), pl=p.length();
        if(pl>sl) return res;
        int[] pat = new int[26];  
        for(char ch: p.toCharArray()){
            pat[ch-'a']++;
        }        
        int win[] = new int[26];
        for(char ch: s.substring(0, pl).toCharArray()){
            win[ch-'a']++;
        }        
        if(Arrays.equals(win, pat)) res.add(0);        
        if(s.length() == p.length()){            
            return res;
        }        
        for(int i=1; i<=sl-pl; i++){
            win[s.charAt(i-1)-'a']--;
            win[s.charAt(i+pl-1)-'a']++;
            if(Arrays.equals(win, pat)){
                res.add(i);
            }
        }        
        return res;
    }
}
