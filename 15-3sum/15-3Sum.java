class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //brute would be 3 nested loops checking every possibility
        //we can fix an element then do two pointers this way n square me ho jayega
        Arrays.sort(nums);
        HashSet<List<Integer>>anss=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                List<Integer>triplet=new ArrayList<>();
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    anss.add(triplet);
                    j++;
                    k--;
                }
            }
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(List<Integer> i:anss){
            ans.add(i);
        }
        return ans;
    }
}