class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod=(int)1e9+7;
        int[]pse=getpse(arr);
        int[]nse=getnse(arr);
        long sum=0;
        for(int i=0;i<arr.length;i++){
            long prev=i-pse[i];
            long next=nse[i]-i;
            long add=(long)prev*next*arr[i];
            sum=(sum+add)%mod;
        }
        return (int)sum;
    }

    public int[] getpse(int[]arr){
        int[]a=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty())a[i]=-1;
            else a[i]=st.peek();
            st.push(i);
        }
        return a;
    }

    public int[] getnse(int[]arr){
        int[]a=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty())a[i]=arr.length;
            else a[i]=st.peek();
            st.push(i);
        }
        return a;
    }
}