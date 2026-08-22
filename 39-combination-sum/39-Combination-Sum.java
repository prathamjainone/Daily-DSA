class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        combo(candidates,target,0,ans,temp);
        return ans;
    }

    public void combo(int[]arr,int k,int i,List<List<Integer>>ans,List<Integer>temp){
        if(i==arr.length){
            return;
        }
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(k<0){
            return;
        }
        //pick
        temp.add(arr[i]);
        combo(arr,k-arr[i],i,ans,temp);
        temp.remove(temp.size()-1);
        //skip
        combo(arr,k,i+1,ans,temp);
    }
}