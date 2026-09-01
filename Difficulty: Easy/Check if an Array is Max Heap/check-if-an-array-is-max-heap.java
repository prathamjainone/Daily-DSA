class Solution {
    public boolean isMaxHeap(int[] arr) {
        // code here
         for(int i=0;i<arr.length/2;i++){
             if(!heapdown(arr,i))return false;
         }
         return true;
    }
    
    public boolean heapdown(int[] arr,int idx){
        int large=idx;
        int l=(idx*2)+1;
        int r=(idx*2)+2;
        boolean left=true;
        boolean right=true;
        if(l<arr.length && arr[l]>arr[idx])left=false;
        if(r<arr.length && arr[r]>arr[idx])right=false;
        return left&&right;
    }
}