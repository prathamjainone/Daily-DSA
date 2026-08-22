class Solution {
    public int median(int[][] matrix) {
        // c
        int n=matrix.length;
        int m=matrix[0].length;

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            low=Math.min(low,matrix[i][0]);
            high=Math.max(high,matrix[i][m-1]);
        }

        int required=(n*m)/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            int count=countlessthan(matrix,n,m,mid);

            if(count>required)high=mid-1;
            else low=mid+1;
        }

        return low;
    }
    
    public int countlessthan(int[][]matrix,int n,int m,int mid){
         int count=0;
        for(int i=0;i<n;i++){

        int ans=m;
            int low=0;
            int high=m-1;
            while(low<=high){
                int md=low+(high-low)/2;
                if(matrix[i][md]>mid){
                    ans=md;
                    high=md-1;
                }
                else{
                    low=md+1;
                }
            }
            count+=ans;
        }
        return count;
    }
}