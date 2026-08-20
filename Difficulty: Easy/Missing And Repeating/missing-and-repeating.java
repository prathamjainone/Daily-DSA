class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int xr=0;
        for(int i=0;i<arr.length;i++){
            xr^=arr[i];
            xr^=(i+1);
        }
        int rightmost=xr&~(xr-1);
        int one=0;
        int zero=0;
        for(int i=0;i<arr.length;i++){
            if((rightmost & arr[i])!=0){
                one^=arr[i];
            }
            else{
                zero^=arr[i];
            }
        }
        for(int i=1;i<=arr.length;i++){
            if((rightmost & i)!=0){
                one^=i;
            }
            else{
                zero^=i;
            }
        }
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==zero)cnt++;
        }
        ArrayList<Integer>ans=new ArrayList<>();
        if(cnt!=0){
            ans.add(zero);
            ans.add(one);
        }
        else{
            ans.add(one);
            ans.add(zero);
        }
        return ans;
    }
}
