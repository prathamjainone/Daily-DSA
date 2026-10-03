class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length; // Size of the array 

        int ans = 0; // To store the result
        int maxLen = 0; // To store the length of longest LIS

        int[] dp = new int[n]; // DP table
        int[] count = new int[n]; // To store the count

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for(int ind = 0; ind < n; ind++) {
            for(int prevInd = 0; prevInd < ind; prevInd++) {

                /* If the element at index i can be included
                in the LIS ending at index j */
                if(nums[prevInd] < nums[ind]) {

                    // If a longer LIS is found, update the values
                    if(dp[prevInd] + 1 > dp[ind]) {
                        dp[ind] = dp[prevInd] + 1;
                        count[ind] = count[prevInd];
                    }

                    // Else if a new way is found to form the LIS
                    else if(dp[prevInd] + 1 == dp[ind]) {
                        count[ind] += count[prevInd];
                    }

                }
            }

            // Store the maximum length
            maxLen = Math.max(maxLen, dp[ind]);
        }

         // Traverse the count array 
        for(int i = 0; i < n; i++) {
            // Count the longest LIS
            if(dp[i] == maxLen) ans += count[i];
        }

        return ans; // Return the result
    }
}