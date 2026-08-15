class Solution {
    public int[] twoSum(int[] nums, int target) {
        //brute force would be nested loop checking every possibility
        //optimal would be to use hashmap and store sum,index

        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }   
        return new int[]{-1,-1};
    }
}