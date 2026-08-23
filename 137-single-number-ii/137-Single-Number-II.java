class Solution {
    public int singleNumber(int[] nums) {
        // int ans=0;
        // for(int i=0;i<=31;i++){
        //     int count=0;
        //     for(int j=0;j<nums.length;j++){
        //         if((1<<i & nums[j])!=0)count++;
        //     }
        //     count=count%3;
        //     if(count!=0)ans+=1<<i;
        // }
        // return ans;

        // Arrays.sort(nums);
        // for(int i=1;i<nums.length;i=i+3){
        //     if(nums[i]==nums[i-1] && nums[i]==nums[i+1])continue;
        //     else{
        //         return nums[i-1];
        //     }
        // }
        // return nums[nums.length-1];

        int one=0;
        int two=0;
        for(int i=0;i<nums.length;i++){
            one=(one^nums[i])&~two;
            two=(two^nums[i])&~one;
        }
        return one;
    }
}