class Solution {
    public int majorityElement(int[] nums) {
        //we can either do nested loop
        //optimize it with visited array to make sure every num is calculated once
        //use hashmap
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()>nums.length/2)return entry.getKey();
        }
        return -1;
    }
}