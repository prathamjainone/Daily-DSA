class Solution {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int start = -1;
        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            
            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            hash[s.charAt(right)]--;
            while (count == t.length()) {
                if (right - left + 1 < min) {
                    min = Math.min(min, right - left + 1);
                    start=left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0){
                    count--;
                }
                left++;
            }
            right++;
        }
        if(start==-1)return "";
        return s.substring(start,start+min);
    }
}