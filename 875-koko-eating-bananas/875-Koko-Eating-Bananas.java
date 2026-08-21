class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=1;
        for(int i:piles){
            high=Math.max(i,high);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            long hrs=0;
            for(int i=0;i<piles.length;i++){
                long s=(piles[i]+mid-1)/mid;
                hrs+=s;
            }
            if(hrs>h)low=mid+1;
            else high=mid-1;
        }
        
    return low;
    }
}