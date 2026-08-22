class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=matrix.length-1;
        boolean ans=false;
        while(low<=high){
            int mid=low+(high-low)/2;
            int inlow=0;
            int inhigh=matrix[mid].length-1;
            if(target>=matrix[mid][inlow] && target<=matrix[mid][inhigh]){
                while(inlow<=inhigh){
                    int inmid=inlow+(inhigh-inlow)/2;
                    if(matrix[mid][inmid]==target){
                        ans=true;
                        break;
                    }
                    else if(matrix[mid][inmid]<target)inlow=inmid+1;
                    else inhigh=inmid-1;
                }
                return ans;
            }
            if(target<matrix[mid][inlow]){
                high=mid-1;
            }
            else if(target>matrix[mid][inhigh]){
                low=mid+1;
            }
        }
        return ans;
    }
}