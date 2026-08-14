class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            List<Integer>temp=new ArrayList<>();
            for(int j=1;j<=i;j++){
                if(j==i || j==1){
                    temp.add(1);
                }
                else{
                    temp.add(ans.get(i-2).get(j-2)+ans.get(i-2).get(j-1));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}