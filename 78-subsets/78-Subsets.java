class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        subs(nums,ans,temp,0);
        return ans;
    }

    public void subs(int[]nums,List<List<Integer>>ans,List<Integer>temp,int i){
        if(i>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //pick
        temp.add(nums[i]);
        subs(nums,ans,temp,i+1);
        temp.remove(temp.size()-1);
        //skip
        subs(nums,ans,temp,i+1);
    }
}