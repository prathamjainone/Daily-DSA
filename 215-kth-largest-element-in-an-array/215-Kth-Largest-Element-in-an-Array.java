class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qs(nums,k,0,nums.length-1);
    }

    public int qs(int[]nums,int k,int low,int high){
        int p=partition(nums,low,high);
        if(p==k-1)return nums[p];
        else if(p>k-1){
            return qs(nums,k,low,p-1);
        }
        return qs(nums,k,p+1,high);
        
    }

    public int partition(int[]nums,int low,int high){
        int p=(int)(Math.random()*(high-low+1))+low;
        int temp=nums[p];
        nums[p]=nums[low];
        nums[low]=temp;

        int l=low+1;
        int r=high;
        while(l<=r){
            if(nums[l]<nums[low] && nums[r]>nums[low]){
                temp=nums[r];
                nums[r]=nums[l];
                nums[l]=temp;
                l++;
                r--;
            }
            if(nums[l]>=nums[low])l++;
            if(nums[r]<=nums[low])r--;
        }
        temp=nums[r];
        nums[r]=nums[low];
        nums[low]=temp;
        return r;
    }
}