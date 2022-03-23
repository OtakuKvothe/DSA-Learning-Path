//https://leetcode.com/problems/smallest-string-with-a-given-numeric-value
public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        StringBuilder res = new StringBuilder();
        k -= n;
        for(int i=n-1; i>=0; i--) {
            int r=1;
            if(k > 25) {
                r+=25;
                k-=25;
            } else if(k > 0) {
                r+=k;
                k=0;
            }
            res.append((char)(r+'a'-1));
        }
        return res.reverse().toString();
    }
}
