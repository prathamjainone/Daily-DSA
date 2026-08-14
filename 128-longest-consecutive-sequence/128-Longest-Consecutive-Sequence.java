class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        int max=1;
        int last=nums[0];
        int current=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==last+1){
                current++;
                last=nums[i];
                max=Math.max(current,max);
            }
            else if(nums[i]!=last){
                current=1;
                last=nums[i];
            }
        }   
        return max;
    }
}