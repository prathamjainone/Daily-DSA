class Solution {
    public int rob(int[] money) {
        if(money.length==1)return money[0];
        int arr1[]=new int[money.length-1];
        int arr2[]=new int[money.length-1];

        for(int i=0;i<money.length;i++){
            if(i!=money.length-1){
                arr1[i]=money[i];
            }
            if(i!=0){
                arr2[i-1]=money[i];
            }
        }
        int firstskip=robb(arr2);
        int lastskip=robb(arr1);
        return Math.max(firstskip,lastskip);
    }

    public int robb(int[]arr){
        int plus1=0;
        int plus2=0;
        int max=0;
        for(int i=arr.length-1;i>=0;i--){
            max=Math.max(plus1,arr[i]+plus2);
            plus2=plus1;
            plus1=max;
        }

        return max;
    }
}