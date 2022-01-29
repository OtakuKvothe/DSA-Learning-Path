//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class BTTBASTwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        long hold = Integer.MIN_VALUE, sold = 0;
        for(int price: prices){
            long sold_prev = sold;
            sold = Math.max(hold+price-fee, sold);
            hold = Math.max(hold, sold_prev-price);
        }
        return (int)sold;
    }
}
