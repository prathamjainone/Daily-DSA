class Solution {
    
    public int minPlatform(int Arrival[], int Departure[]) {
        //  code here
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int platforms=0;
        int i=0;
        int j=0;
        int max=0;
        while(i<Arrival.length && j<Departure.length){
            if(Arrival[i]<=Departure[j]){
                platforms++;
                max=Math.max(max,platforms);
                i++;
            }
            else{
                platforms--;
                j++;
            }
        }
        return max;
    }
}
