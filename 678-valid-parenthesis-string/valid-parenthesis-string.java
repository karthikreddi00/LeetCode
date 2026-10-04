class Solution {
    public boolean checkValidString(String s) {
        int f = 0;
        int l = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                f++;
                l++;
            }else if(ch == ')'){
                f = Math.max(0, f - 1);
                l--;
            }else{
                f = Math.max(0, f - 1);
                l++;
            }
        if(l < 0) return false;
        }
        return f == 0;
    }
}