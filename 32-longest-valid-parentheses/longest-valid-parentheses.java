class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int ans = 0;
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}