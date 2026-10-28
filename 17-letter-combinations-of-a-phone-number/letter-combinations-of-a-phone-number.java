class Solution {

    public static void backtracking(String digits, int n, List<String> ans, StringBuilder cur, String[] dail, int i){
        if(cur.length() == n) {
        ans.add(new String(cur));
        return;
        }
        int id = digits.charAt(i) - '0';
          for(char ch : dail[id - 2].toCharArray()){
            cur.append(ch);
            backtracking(digits, n, ans, cur, dail, i + 1);
            cur.deleteCharAt(cur.length() - 1);
          }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        String[] dail = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(digits, n, ans, new StringBuilder(), dail, 0);
        return ans;
    }
}