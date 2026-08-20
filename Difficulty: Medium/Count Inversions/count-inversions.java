class Solution {
    public int inversionCount(int arr[]) {
        // code here
        return inversions(arr,0,arr.length-1);
    }
    
    public int inversions(int[]arr,int low,int high){
        if(low>=high)return 0;
        int mid=low+(high-low)/2;
        int i=0;
        i+=inversions(arr,low,mid);
        i+=inversions(arr,mid+1,high);
        i+=icount(arr,low,mid,high);
        return i;
    }
    
    public int icount(int[]arr,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        ArrayList<Integer>temp=new ArrayList<>();
        int i=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                i+=mid-left+1;
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int j=low;j<=high;j++){
            arr[j]=temp.get(j-low);
        }
        return i;
    }
}