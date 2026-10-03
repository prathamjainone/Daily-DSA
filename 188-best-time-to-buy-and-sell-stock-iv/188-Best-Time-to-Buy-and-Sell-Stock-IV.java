class Solution {
    public int maxProfit(int k, int[] prices) {
        int curr[][]=new int[k+1][2];
        int ahead[][]=new int[k+1][2];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int profit = 0;
                for (int l = 1; l <= k; l++) {
                    if (j == 0)
                        curr[l][j] = Math.max(ahead[l][j], -prices[i] + ahead[l][1]);
                    if (j == 1)
                        curr[l][j] = Math.max(ahead[l][j], prices[i] + ahead[l-1][0]);   
                }
            }
            ahead=curr;
        }
        return ahead[k][0];
    }
}