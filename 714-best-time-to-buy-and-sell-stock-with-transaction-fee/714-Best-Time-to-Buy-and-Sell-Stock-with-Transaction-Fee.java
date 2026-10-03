class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length+1][2];
        dp[prices.length][0]=0;
        dp[prices.length][1]=0;

        for(int i=prices.length-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                int profit=0;
                if(j==0)profit=-prices[i]+dp[i+1][1];
                if(j==1)profit=prices[i]-fee+dp[i+1][0];
                int skip=dp[i+1][j];
                dp[i][j]=Math.max(profit,skip);
            }
        }
       return dp[0][0];
    }
}