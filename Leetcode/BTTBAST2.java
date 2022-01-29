//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
public class BTTBAST2 {
    public int maxProfit(int[] prices) {
        long hold=Integer.MIN_VALUE, sold=0;
        for(int price: prices){
            long sold_prev=sold;
            sold=Math.max(hold+price, sold);
            hold=Math.max(sold_prev-price, hold);
        }
        return (int)sold;
    }
}
