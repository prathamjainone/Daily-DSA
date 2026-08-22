class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length)return -1;
        
        long low=0;
        long high=0;
        for(int i:arr){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            long mid=low+(high-low)/2;
            int b=1;
            long sum=0;
            for(int i=0;i<arr.length;i++){
                if(sum+arr[i]>mid){
                    b++;
                    sum=arr[i];
                }
                else sum+=arr[i];
            }
            if(b>k)low=mid+1;
            else high=mid-1;
        }
        return (int)low;
    }
}