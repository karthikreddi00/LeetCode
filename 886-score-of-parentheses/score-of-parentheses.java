class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ans);
               ans = 0;
            }else{
             ans = stack.pop() + Math.max(ans * 2, 1);
            }
        }
        return ans;
    }
}