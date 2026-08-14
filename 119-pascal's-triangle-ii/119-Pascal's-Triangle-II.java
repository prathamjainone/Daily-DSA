class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>row=new ArrayList<>();
        long prev=1;
        row.add((int)prev);
        for(int i=1;i<=rowIndex;i++){
            prev=prev*(rowIndex+1-i);
            prev=prev/i;
            row.add((int)prev);
        }

        return row;
    }
}