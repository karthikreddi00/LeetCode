class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int rem = sum % 9;
        int div = sum / 9;
        if(num < div + ((rem != 0)? 1 : 0)) return "";
        StringBuilder sb = new StringBuilder();
     sb.append("9".repeat(div));
       if(rem != 0) sb.append(rem);
       int di = num - sb.length();
      sb.append("0".repeat(di));
       return sb.toString();
    }
}