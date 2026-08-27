class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (!st.isEmpty() && st.peek() > 0) {
                    while (!st.isEmpty() && st.peek() < Math.abs(nums[i]))
                        if(st.peek()>0)st.pop();
                        else break;
                    if (!st.isEmpty() && st.peek() == Math.abs(nums[i])) {
                            st.pop();
                            continue;
                        }
                    else if(!st.isEmpty() && st.peek() > Math.abs(nums[i]))
                        continue;
                    }
                }
            st.push(nums[i]);
        }

    ArrayList<Integer> a = new ArrayList<>();
    for(int i:st)a.add(i);
    int ans[] = new int[a.size()];
    for(int i = a.size() - 1;i>=0;i--){
        ans[i] = a.get(i);
    }
    return ans;
}
}