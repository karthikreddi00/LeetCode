class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int rem = sum % 9;
        int div = sum / 9;
        if(num < div + ((rem != 0)? 1 : 0)) return "";
        StringBuilder sb = new StringBuilder();
       for(int i = 0; i < div; i++){
            sb.append(9);
       }
       if(rem != 0) sb.append(rem);
       int di = num - sb.length();
       for(int i = 0; i < di; i++){
        sb.append(0);
       }
       return sb.toString();
    }
}