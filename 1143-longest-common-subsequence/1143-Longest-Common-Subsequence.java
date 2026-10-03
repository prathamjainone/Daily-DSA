class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int next[]=new int[str2.length()+1];
        for(int i=str1.length()-1;i>=0;i--){
            int curr[]=new int[str2.length()+1];
            for(int j=str2.length()-1;j>=0;j--){
                int match=0;
                if(str1.charAt(i)==str2.charAt(j))match=1+next[j+1];
                int skip1=next[j];
                int skip2=curr[j+1];

                curr[j]=Math.max(match,Math.max(skip1,skip2));
            }
            next=curr;
        }
        return next[0];
    }

}