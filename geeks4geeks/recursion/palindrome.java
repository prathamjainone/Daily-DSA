class Solution {
    boolean isPalindrome(String s) {
        // code here
        return pali(s,0,s.length()-1);
    }
    
    public boolean pali(String s,int start,int end){
        if(start>=end)return true;
        
        if(s.charAt(start)!=s.charAt(end))return false;
        
        return pali(s,start+1,end-1);
    }
}