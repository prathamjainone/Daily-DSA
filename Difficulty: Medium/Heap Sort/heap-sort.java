class Solution {
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[]) {
        // code here
        for(int i=arr.length/2;i>=0;i--){
            heapdown(arr,i,arr.length);
        }
        
        int last=arr.length-1;
        while(last>0){
            int temp=arr[0];
            arr[0]=arr[last];
            arr[last]=temp;
            heapdown(arr,0,last);
            last--;
        }
    }
    
    public void heapdown(int arr[],int idx,int end){
        int max=idx;
        int left=(idx*2)+1;
        int right=(idx*2)+2;
        if(left<end && arr[left]>arr[max])max=left;
        if(right<end && arr[right]>arr[max])max=right;
        
        if(max!=idx){
            int temp=arr[max];
            arr[max]=arr[idx];
            arr[idx]=temp;
            heapdown(arr,max,end);
        }
    }
}