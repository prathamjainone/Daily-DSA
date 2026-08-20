class Solution {
    public int reversePairs(int[] nums) {
        return mergesol(nums,0,nums.length-1);
    }

    public int mergesol(int[]nums,int low,int high){
        if(low>=high)return 0;
        int mid=low+(high-low)/2;
        int pairs=0;
        pairs+=mergesol(nums,low,mid);
        pairs+=mergesol(nums,mid+1,high);
        pairs+=countpairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return pairs;
    }

    public void merge(int[]nums,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int []temp=new int[high-low+1];
        int i=0;
        while(left<=mid && right<=high){
            if(nums[left]<nums[right]){
                temp[i++]=nums[left];
                left++;
            }
            else{
                temp[i++]=nums[right];
                right++;
            }
        }
        while(left<=mid){
            temp[i++]=nums[left];
            left++;
        }
        while(right<=high){
            temp[i++]=nums[right];
            right++;
        }

        for(int j=low;j<=high;j++){
            nums[j]=temp[j-low];
        }
    }
    public int countpairs(int[]nums,int low,int mid,int high){
        int pairs=0;
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
            if((long)nums[left]>2*(long)nums[right]){
            pairs+=mid-left+1;
            right++;
        }
        else{
            left++;
        }
        }
        return pairs;
    }
}