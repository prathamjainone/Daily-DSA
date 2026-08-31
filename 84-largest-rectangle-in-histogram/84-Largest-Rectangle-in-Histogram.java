class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer>st=new Stack<>();
        int max=Integer.MIN_VALUE;
        int area;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                int el=arr[st.pop()];
                int pse=(st.isEmpty())?-1:st.peek();
                area=el*(i-pse-1);
                max=Math.max(area,max);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int el=arr[st.pop()];
            int pse=(st.isEmpty())?-1:st.peek();
            area=el*(arr.length-pse-1);
            max=Math.max(area,max);
        }
        return max;
    }
}