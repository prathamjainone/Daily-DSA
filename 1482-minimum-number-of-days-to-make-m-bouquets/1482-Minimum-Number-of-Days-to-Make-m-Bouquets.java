class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)return -1;

        int low=1;
        int high=1;
        int max=1;
        for(int i:bloomDay){
            high=Math.max(high,i);
            max=Math.max(max,i);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int bq=m;
            int streak=0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=mid){
                    streak++;
                    if(streak==k){
                        bq--;
                        streak=0;
                    }
                }
                else{
                    streak=0;
                }
            }
            if(bq>0)low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}