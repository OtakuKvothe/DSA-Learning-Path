//https://leetcode.com/problems/arranging-coins
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if(n==1||n==2) return 1;
        if(n==3) return 2;
        
        long start = 2, end = n/2;
        while(start <= end) {
            long mid = start + (end - start)/2;
            long rows = mid*(mid+1)/2;
            if(rows == n) return (int) mid;
            if(rows < n){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return (int)end;
    }
}

//Same problem solved using bit manipulation and 2 other ways: https://leetcode.com/problems/arranging-coins/discuss/1559913/Java-3-Solutions-Bit-Manipulation-Binary-Search-Math-or-TC%3A-O(1)-SC%3A-O(1)-or-Beats-100