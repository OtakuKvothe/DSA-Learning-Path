//https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options
public class CountAllValidPickupAndDelivery {
    public int countOrders(int n) {
        if(n==1) return 1;
        long dp = 6;
        for(int i=3; i<=n; i++){
            dp = i*(2*i-1)*dp%1000000007;
        }
        return (int)dp%1000000007;
    }
}
