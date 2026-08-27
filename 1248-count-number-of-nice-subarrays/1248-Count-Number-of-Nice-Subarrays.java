class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }

    public int helper(int[]nums,int k){
        if(k==-1)return 0;
        int left=0;
        int right=0;
        int n=0;
        int odds=0;
        while(right<nums.length){
            if(nums[right]%2!=0)odds++;
            while(odds>k){
                if(nums[left]%2!=0)odds--;
                left++;
            }
            n+=right-left+1;
            right++;
        }
        return n;
    }
}