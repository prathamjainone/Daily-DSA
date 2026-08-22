class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        palipart(s, ans, temp, 0);
        return ans;
    }

    public void palipart(String s, List<List<String>> ans, List<String> temp, int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        //pick and check
        for (int j = i+1; j <= s.length(); j++) {
            String t = s.substring(i, j);
            if (checkPali(t)){
                temp.add(t);
                palipart(s, ans, temp, j);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean checkPali(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean ans = true;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                ans = false;
                break;
            }
            i++;
            j--;
        }
        return ans;
    }
}