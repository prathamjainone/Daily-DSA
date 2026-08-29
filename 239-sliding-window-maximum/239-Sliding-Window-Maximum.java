class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq=new ArrayDeque<>();

        //kuch bada aajaye toh pop everything else push it
        int ans[]=new int[nums.length-k+1];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(i<k-1){
                while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                    dq.pollLast();
                }
                dq.offerLast(i);
            }
            else{
                while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                    dq.pollLast();
                }
                dq.offerLast(i);
                if(dq.peekFirst()<=i-k)dq.pollFirst();
                ans[idx++]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}