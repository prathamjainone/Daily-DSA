class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        s(nums,0,ans,temp);
        return ans;
    }
    public void s(int[]nums,int i,List<List<Integer>>ans,List<Integer>temp){
        if(i>nums.length-1){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //add
        temp.add(nums[i]);
        s(nums,i+1,ans,temp);
        temp.remove(temp.size()-1);
        //skip
        s(nums,i+1,ans,temp);
    }
}