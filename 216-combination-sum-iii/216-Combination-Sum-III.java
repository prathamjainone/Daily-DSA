class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        combo(1,k,n,ans,temp);
        return ans;
    }

    public void combo(int i,int k,int n,List<List<Integer>>ans,List<Integer>temp){
        if(k==0){
            if(n==0){
                ans.add(new ArrayList<>(temp));
                return;
            }
            else return;
        }
        if(i==10)return;

        //pick
        temp.add(i);
        combo(i+1,k-1,n-i,ans,temp);
        temp.remove(temp.size()-1);
        //skip
        combo(i+1,k,n,ans,temp);
    }
}