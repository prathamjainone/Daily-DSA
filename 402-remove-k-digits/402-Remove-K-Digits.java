class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length())return "0";

        Stack<Character>st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while((!st.isEmpty() && Integer.valueOf(st.peek())>Integer.valueOf(num.charAt(i)))&& k>0){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb=sb.reverse();
        int j=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0')j=i+1;
            else break;
        }
        String ans=sb.toString();
        return (ans.substring(j)=="")?"0":ans.substring(j);
    }
}