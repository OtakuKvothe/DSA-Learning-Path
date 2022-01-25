//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
public class BTTBASTwithCooldown {
    public int maxProfit(int[] p) {
        if (p.length <= 1)
            return 0;
        int buy, sell, buyp, sellp;
        sellp = 0;
        buyp = 0;
        buy = Integer.MIN_VALUE;
        sell = 0;
        for (int i = 0; i < p.length; i++) {
            buyp = buy;
            buy = Math.max(sellp - p[i], buyp);
            sellp = sell;
            sell = Math.max(buyp + p[i], sellp);
        }
        return sell;
    }
}
