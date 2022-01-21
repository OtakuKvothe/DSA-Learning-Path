//https://leetcode.com/problems/partition-labels
import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if(s.length()==0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] las = new int[26];
        for(int i=0; i<s.length(); i++){
            las[s.charAt(i)-'a']=i;
        }
        int st=0, l=0;
        for(int i=0; i<s.length(); i++){
            l=Math.max(l, las[s.charAt(i)-'a']);
            if(l==i){
                res.add(l-st+1);
                st=l+1;
            }
        }
        return res;
    }
}
