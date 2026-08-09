class Solution {
    public static int gcd(int a, int b) {
        // code here
        while(a!=0 && b!=0){
            if(a>b)a=a-b;
            else b=b-a;
        }
        if(b==0)return a;
        return b;
    }
}
