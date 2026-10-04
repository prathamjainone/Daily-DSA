class Solution {
    public boolean isMatch(String s, String p) {
        int ahead[]=new int[p.length() + 1];
        ahead[p.length()] = 1;
        for (int j = p.length() - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                ahead[j] = ahead[j + 1];
            } else {
                ahead[j] = 0;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr[]=new int[p.length() + 1];
            for (int j = p.length() - 1; j >= 0; j--) {
                int ans = 0;
                if (s.charAt(i) == p.charAt(j))
                    ans = ahead[j+1];
                else {
                    if (p.charAt(j) != '*' && p.charAt(j) != '?')
                        ans = 0;
                    else if (p.charAt(j) == '?')
                        ans = ahead[j+1];
                    else {
                        int skipstar = curr[j+1];
                        int skipelem = ahead[j];
                        if(skipstar==1)ans=1;
                        else if(skipelem==1)ans=1;
                        else ans=0;
                    }
                }
                curr[j]=ans;
            }
            ahead=curr;
        }

        return ahead[0] == 1;
    }
}