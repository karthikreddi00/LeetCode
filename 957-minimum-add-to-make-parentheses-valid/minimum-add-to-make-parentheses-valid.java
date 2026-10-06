class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                  stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    ans++;
                }else{
                    stack.pop();
                }
            }
        }
        return ans + stack.size();
    }
}