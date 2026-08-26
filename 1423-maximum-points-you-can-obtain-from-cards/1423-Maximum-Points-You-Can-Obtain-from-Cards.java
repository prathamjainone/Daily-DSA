class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int rsum=0;
        int lind=0;
        int rind=cardPoints.length-1;
        int max=0;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
            lind++;
        }
        max=Math.max(max,lsum);
        if(lind==cardPoints.length)return max;
        for(int i=0;i<k;i++){
            lsum-=cardPoints[lind-1];
            lind--;
            rsum+=cardPoints[rind];
            rind--;
            max=Math.max(max,lsum+rsum);
        }
        return max;
    }
}