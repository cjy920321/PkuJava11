public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length > 0)
        {
            int low = prices[0];
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
            {
                if (low > prices[i - 1])
                {
                    low = prices[i - 1];
                }
                profit = prices[i] - low;
                if (profit > max)
                {
                    max = profit;
                }
            }
        }
        return max;
    }
}