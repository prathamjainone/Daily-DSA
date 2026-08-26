class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;
        int left=0;
        int right=0;
        int hash[]=new int[26];
        int freqmax=0;
        while(right<s.length()){
            hash[s.charAt(right)-'A']++;
            freqmax=Math.max(freqmax,hash[s.charAt(right)-'A']);
            if(right-left+1-freqmax>k){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}