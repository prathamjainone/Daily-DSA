class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[amount+1][coins.length];
        for(int []d:dp)Arrays.fill(d,-1);
        return ways(amount,coins,0,dp);
    }
    public int ways(int amount,int[]coins,int i,int dp[][]){
        if(amount<0)return 0;
        if(amount==0)return 1;
        if(i>=coins.length)return 0;
        if(dp[amount][i]!=-1)return dp[amount][i];

        int keep=ways(amount-coins[i],coins,i,dp);
        int skip=ways(amount,coins,i+1,dp);

        return dp[amount][i]=keep+skip;
    }
}