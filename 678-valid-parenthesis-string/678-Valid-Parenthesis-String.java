class Solution {
    public boolean checkValidString(String s) {
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int[]p:dp){
                Arrays.fill(p,-1);
        }
        
        return check(s,0,0,dp);
    }

    public boolean check(String s,int i,int count,int dp[][]){
        if(i>=s.length()){
            if(count==0)return true;
            return false;
        }
        if(count<0)return false;
        if(dp[i][count]!=-1)return (dp[i][count]==0)?false:true;
        boolean ans1=false;
        boolean ans2=false;
        boolean ans3=false;
        if(s.charAt(i)=='('){
            ans1=check(s,i+1,count+1,dp);
        }
        else if(s.charAt(i)==')'){
            ans2=check(s,i+1,count-1,dp);
        }
        else{
            ans3=check(s,i+1,count,dp)||check(s,i+1,count+1,dp)||check(s,i+1,count-1,dp);
        }
        boolean ans=(ans1||ans2)||ans3;
        dp[i][count]=(ans==true)?1:0;
        return ans;
    }
}