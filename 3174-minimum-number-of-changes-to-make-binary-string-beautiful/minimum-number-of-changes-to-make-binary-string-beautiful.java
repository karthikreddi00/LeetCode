class Solution {
    public int minChanges(String s) {
        int ans = 0;
        int n = s.length();
        char pre = s.charAt(0);
        int precount = 1;
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            if(ch == pre){
                 precount++;
            }else{
                if(precount % 2 != 0){
                    ans++;
                    precount = 0;
                    pre = ch;
                    continue;
                }
                precount = 1;
                pre = ch;
            }
        }
        if(precount % 2 != 0) ans++;
        return ans;
    }
}