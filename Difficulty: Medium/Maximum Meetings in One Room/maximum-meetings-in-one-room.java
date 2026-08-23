class Solution {
    public class Pair{
        int start;
        int end;
        int pos;
        Pair(int s,int e,int p){
            this.start=s;
            this.end=e;
            this.pos=p;
        }
    }

    
    public ArrayList<Integer> maxMeetings(int[] start, int[] end) {
        // code here
        Pair pair[]=new Pair[start.length];
        for(int i=0;i<start.length;i++){
         pair[i]=new Pair(start[i],end[i],i+1);
        }
        Arrays.sort(pair,(a,b)->{
         return a.end-b.end;
        });
        
        ArrayList<Integer>ans=new ArrayList<>();
        int lastend=pair[0].end;
        ans.add(pair[0].pos);
        for(int i=1;i<start.length;i++){
         if(pair[i].start>lastend){
             lastend=pair[i].end;
             ans.add(pair[i].pos);
         }
        }
        Collections.sort(ans)
        ;
        return ans;
    }
}