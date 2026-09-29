class Solution {
    public int rob(int[] money) {
        int dp[]=new int[money.length];
        int dp2[]=new int[money.length];
        Arrays.fill(dp2,-1);
        Arrays.fill(dp,-1);
        if(money.length==1)return money[0];
        return Math.max(robb(money,0,money.length-2,dp),robb(money,1,money.length-1,dp2));
    }

    public int robb(int[]money,int i,int j,int[]dp){
        if(i>j)return 0;
        if(dp[i]!=-1)return dp[i];
        //take
        int take=money[i]+robb(money,i+2,j,dp);
        //skip
        int skip=robb(money,i+1,j,dp);

        return dp[i]=Math.max(take,skip);
    }
}