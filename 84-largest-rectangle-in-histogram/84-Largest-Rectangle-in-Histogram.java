class Solution {
    public int largestRectangleArea(int[] heights) {
        int[]pse=pse(heights);
        int[]nse=nse(heights);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int l=pse[i]+1;
            int r=nse[i]-1;
            int area=(r-l+1)*heights[i];
            max=Math.max(max,area);
        }
        return max;
    }
    public int []nse(int[]arr){
        Stack<Integer>st=new Stack<>();
        int nse[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=arr.length;
            }
            else nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }
    public int []pse(int[]arr){
        Stack<Integer>st=new Stack<>();
        int pse[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else pse[i]=st.peek();
            st.push(i);
        }
        return pse;
    }
}