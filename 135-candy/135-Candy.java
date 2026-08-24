class Solution {
    public int candy(int[] ratings) {
        int sum=1;
        int peak=1;
        int neeche=0;
        int i=1;
        while(i<ratings.length){
            if(ratings[i]==ratings[i-1]){
                sum+=1;
                peak=1;
                neeche=0;
                i++;
            }
            else if(ratings[i]>ratings[i-1]){
                peak=1;
                while(i<ratings.length && ratings[i]>ratings[i-1]){
                    peak++;
                    sum+=peak;
                    i++;
                }
            }
            else if(ratings[i]<ratings[i-1]){
                neeche=0;
                while(i<ratings.length && ratings[i]<ratings[i-1]){
                    neeche++;
                    sum+=neeche;
                    i++;
                }
                if(neeche+1>peak){
                    sum+=neeche+1-peak;
                }
            }
        }
        return sum;
    }
}