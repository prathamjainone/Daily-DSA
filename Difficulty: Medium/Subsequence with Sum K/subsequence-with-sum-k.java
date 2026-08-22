class Solution {
    
        
    public boolean checkSubsequenceSum(int[] arr, int k) {
        int dp[][]=new int[k+1][arr.length+1];
        for(int[]d:dp){
            Arrays.fill(d,-1);
        }
        return check(arr,k,0,dp);
        
    }
    
    public boolean check(int[]arr,int k,int i,int dp[][]){
        if(k<0)return false;
        if(i==arr.length){
            if(k==0)return true;
            return false;
        }
        if(dp[k][i]!=-1)return (dp[k][i]==0)?false:true;
        
        boolean pick=check(arr,k-arr[i],i+1,dp);
        boolean skip=check(arr,k,i+1,dp);
        
        boolean ans= pick||skip;
        dp[k][i]=(ans==true)?1:0;
        return ans;
    }
}