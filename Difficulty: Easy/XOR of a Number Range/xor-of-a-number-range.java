class Solution {
    public static int findXOR(int l, int r) {
        // code here
        int ogl=l;
        int ogr=r;
        l=l%4;
        r=r%4;
        
        //1 to r - 1 to l
        int one2r=0;
        int one2l=0;
        
        if(l==0)one2l=ogl;
        else if(l==1)one2l=1;
        else if(l==2)one2l=ogl+1;
        else one2l=0;
        
        if(r==0)one2r=ogr;
        else if(r==1)one2r=1;
        else if(r==2)one2r=ogr+1;
        else one2r=0;
        
        one2l=one2l^ogl;
        
        return (one2r^one2l);
    }
}