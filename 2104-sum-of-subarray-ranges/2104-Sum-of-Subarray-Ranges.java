class Solution {
    public long subArrayRanges(int[] nums) {
        int[]ng=nge(nums);
        int[]ns=nse(nums);
        int[]ps=pse(nums);
        int[]pg=pge(nums);

        long sum=0;
        for(int i=0;i<nums.length;i++){
            long small=(long)(ns[i]-i)*(i-ps[i])*nums[i];
            long large=(long)(ng[i]-i)*(i-pg[i])*nums[i];
            sum+=large;
            sum-=small;
        }
        return sum;
    }

    public int[] nse(int[] nums){
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int a[]=new int[nums.length];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=n;
            }
            else a[i]=st.peek();
            st.push(i);
        }
        return a;
    }
    public int[] pse(int[] nums){
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int a[]=new int[nums.length];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=-1;
            }
            else a[i]=st.peek();
            st.push(i);
        }
        return a;
    }
    public int[] pge(int[] nums){
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int a[]=new int[nums.length];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=-1;
            }
            else a[i]=st.peek();
            st.push(i);
        }
        return a;
    }
    public int[] nge(int[] nums){
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int a[]=new int[nums.length];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=n;
            }
            else a[i]=st.peek();
            st.push(i);
        }
        return a;
    }
}