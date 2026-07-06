class Solution {
    public int findKthLargest(int[] nums, int k) {
        //brute force
        Arrays.sort(nums);
        int ans=nums[nums.length-1];
        k=k-1;
        for(int i=nums.length-2;i>=0;i--){
            if(k==0)return ans;
            ans=nums[i];
            k--;
        }
        if(k==0)return ans;
        return -1;
    }
}