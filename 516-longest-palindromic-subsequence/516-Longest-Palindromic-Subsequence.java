class Solution {
    public int longestPalindromeSubseq(String s) {
        return lcs(s,new StringBuilder(s).reverse().toString());
    }
    public int lcs( String str1, String str2) {
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str2.length();i++)dp[str1.length()][i]=0;
        for(int i=0;i<=str1.length();i++)dp[i][str2.length()]=0;

        for(int i=str1.length()-1;i>=0;i--){
            for(int j=str2.length()-1;j>=0;j--){
                int match=0;
                if(str1.charAt(i)==str2.charAt(j))match=1+dp[i+1][j+1];
                int skip1=dp[i+1][j];
                int skip2=dp[i][j+1];

                dp[i][j]=Math.max(match,Math.max(skip1,skip2));
            }
        }
        return dp[0][0];
    }
}