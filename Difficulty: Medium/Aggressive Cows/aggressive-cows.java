class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int low=1;
        int high=arr[arr.length-1];
        while(low<=high){
            int mid=low+(high-low)/2;
            int cows=0;
            int prev=-1;
            for(int i=0;i<arr.length;i++){
                if(prev==-1){
                    prev=arr[i];
                    cows++;
                    continue;
                }
                if(arr[i]-prev<mid)continue;
                else if(arr[i]-prev>=mid){
                    prev=arr[i];
                    cows++;
                }
            }
            if(cows>=k)low=mid+1;
            else high=mid-1;
        }
        return high;
    }
}