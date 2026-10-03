class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int[k+1][prices.length][2];
       for(int[][]dd:dp){
        for(int[]d:dd)Arrays.fill(d,-1);
       }
       return stock(prices,k,0,0,dp);
    }
    public int stock(int arr[],int k,int i,int buy,int dp[][][]){
        if(i==arr.length || k==0)return 0;
        if(dp[k][i][buy]!=-1)return dp[k][i][buy];
        int profit=0;

        if(buy==0)profit=Math.max(stock(arr,k,i+1,buy,dp),-arr[i]+stock(arr,k,i+1,1,dp));
        if(buy==1)profit=Math.max(stock(arr,k,i+1,buy,dp),arr[i]+stock(arr,k-1,i+1,0,dp));

        return dp[k][i][buy]=profit;
    }
}