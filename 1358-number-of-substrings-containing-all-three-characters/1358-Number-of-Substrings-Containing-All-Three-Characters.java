class Solution {
    public int numberOfSubstrings(String s) {
        int hash[]=new int[3];
        int left=0;
        int right=0;
        int n=0;
        while(right<s.length()){
            hash[s.charAt(right)-'a']++;
            while((hash[0]>0 && hash[1]>0) && hash[2]>0){
                hash[s.charAt(left)-'a']--;
                left++;
            }
            n+=left;
            right++;
        }
        return n;
    }
}