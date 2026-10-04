class Solution {
    public int minCut(String s) {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return palipart(s,0,dp)-1;
    }

    public int palipart(String s,int i,int[]dp){
        if(i==s.length())return 0;
        if(dp[i]!=-1)return dp[i];
        int min=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(check(i,j,s)){
                int p=1+palipart(s,j+1,dp);
                min=Math.min(min,p);
            }
        }
        return dp[i]=min;
    }

    public boolean check(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}