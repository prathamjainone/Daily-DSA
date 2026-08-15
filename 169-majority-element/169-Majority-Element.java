class Solution {
    public int majorityElement(int[] nums) {
        //we can either do nested loop
        //optimize it with visited array to make sure every num is calculated once
        //use hashmap
        //use simple loop the logic is n/2 se zyada ek hi hoga elem
        if(nums.length==0)return -1;
       int freq=0;
       int el=0;

       for(int i=0;i<nums.length;i++){
        if(freq==0){
            el=nums[i];
            freq=1;
        }
        else if(el==nums[i]){
            freq++;
        }
        else{
            freq--;
        }
       }
       return el;
    }
}