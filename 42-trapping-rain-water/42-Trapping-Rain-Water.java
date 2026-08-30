class Solution {
    public int trap(int[] height) {
        int[] pre=premax(height);
        int[] suf=sufmax(height);
        int sum=0;
        for(int i=0;i<height.length;i++){
            if(height[i]<pre[i] && height[i]<suf[i]){
                sum+=Math.min(pre[i],suf[i])-height[i];
            }
        }
        return sum;
    }

    public int[] premax(int[]arr){
        int max=Integer.MIN_VALUE;
        int p[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            p[i]=max;
        }
        return p;
    }
    public int[] sufmax(int[]arr){
        int max=Integer.MIN_VALUE;
        int s[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            max=Math.max(max,arr[i]);
            s[i]=max;
        }
        return s;
    }
}