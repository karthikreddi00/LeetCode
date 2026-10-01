class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' ||ch == '{'){
               stack.push(ch);
            }else if(ch == ')' || ch == '}' || ch == ']'){
                    if(stack.isEmpty()) return false;
                    char tem = stack.pop();
                    if(ch == ')' && tem != '('){
                      return false;
                    }else if(ch == '}' && tem != '{'){
                        return false;
                    }else if(ch == ']' && tem != '['){
                        return false;
                    }
            }
        }
        return (!stack.isEmpty())? false : true;
    }
}