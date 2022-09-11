//https://leetcode.com/problems/satisfiability-of-equality-equations/

import java.util.ArrayList;
import java.util.List;

public class SatisfiabilityOfEqualityEquations {
    int[] root;
    
    public boolean equationsPossible(String[] equations) {
        root = new int[26];
        for(int i=0; i<26; i++) {
            root[i] = i;
        }
        List<String> nots = new ArrayList<>();
        for(String eq: equations) {
            if(eq.charAt(1) == '!') {
                nots.add(eq);
            } else {
                int x = eq.charAt(0) - 'a', y = eq.charAt(3) - 'a';
                union(x, y);
            }
        }
        
        for(String eq: nots) {
            int x = eq.charAt(0) - 'a', y = eq.charAt(3) - 'a';
            if(find(x) == find(y))
                return false;
        }
        
        return true;
    }
    
    public int find(int x) {
        if(root[x] == x) {
            return root[x];
        }
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if(rx > ry) {
            root[rx] = ry;
        } else {
            root[ry] = rx;
        }
    }
}
