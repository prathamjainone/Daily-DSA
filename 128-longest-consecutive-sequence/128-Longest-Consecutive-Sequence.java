class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=1;

        for(int num:set){
            if(!set.contains(num-1)){
                int current=num;
                int last=1;
                while(set.contains(current+1)){
                    current=current+1;
                    last++;
                }
                max=Math.max(max,last);
            }
        }
        return max;
    }
}