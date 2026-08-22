class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        Arrays.sort(candidates);
        combo(candidates,target,0,ans,temp);
        return ans;
    }

    public void combo(int[] arr,int k,int i,List<List<Integer>>ans,List<Integer>temp){
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i==arr.length || k<0)return;

        temp.add(arr[i]);
        combo(arr,k-arr[i],i+1,ans,temp);
        temp.remove(temp.size()-1);
        for(int j=i;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                combo(arr,k,j,ans,temp);
                break;
            }
        }
    }
}