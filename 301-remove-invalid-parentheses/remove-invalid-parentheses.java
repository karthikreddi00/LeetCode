class Solution {

    public void solve(String s, int index, int left, int right, int balance, StringBuilder curr, Set<String> result) {
        if (balance < 0) {
            return;
        }
        if (index == s.length()) {
            if (left == 0 && right == 0 && balance == 0) {
                result.add(curr.toString());
            }
            return;
        }
        char ch = s.charAt(index);
        // '('
        if (ch == '(') {
            // Remove '('
            if (left > 0) {
                solve(s, index + 1, left - 1, right, balance, curr, result);
            }
            // Keep '('
            curr.append(ch);
            solve(s, index + 1, left, right, balance + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
        // ')'
        else if (ch == ')') {
            // Remove ')'
            if (right > 0) {
                solve(s, index + 1, left, right - 1, balance, curr, result);
            }
            // Keep ')' only if there is '(' to match it
            if (balance > 0) {
                curr.append(ch);
                solve(s, index + 1, left, right, balance - 1, curr, result);
                curr.deleteCharAt(curr.length() - 1);
            }
        }

        // Normal character
        else {
            curr.append(ch);
            solve(s, index + 1, left, right, balance, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        // Find minimum number of '(' and ')' to remove
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            }
            else if (ch == ')') {
                if (left > 0) {
                    left--;
                }
                else {
                    right++;
                }
            }
        }
        Set<String> result = new HashSet<>();
        solve(s, 0, left, right, 0, new StringBuilder(), result);
        return new ArrayList<>(result);
    }
}