//https://leetcode.com/problems/maximum-number-of-coins-you-can-get
import java.util.Arrays;

public class MaxCoins {
    public int maxCoins(int[] p) {
        Arrays.sort(p);
        int l=0, r=p.length-1, c=0;
        while(l<r){
            l++;
            r--;
            c+=p[r--];
        }
        return c;
    }
}
