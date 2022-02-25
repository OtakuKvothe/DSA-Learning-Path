//https://leetcode.com/problems/count-numbers-with-unique-digits/
public class NumUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int res = 10;
        for(int i=2; i<=n; i++){
            int tmp = 9;
            for(int j = 1; j<i; j++){
                tmp *= (10 - j);
            }
            res += tmp;
        }
        return res;
    }
}
