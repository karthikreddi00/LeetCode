class Solution {
    public int smallestNumber(int n, int t) {
      while(true){
        int pro = 1;
        int temp = n;
        while(temp > 0){
            int rem = temp % 10;
            pro *= rem;
            temp /= 10;
        }
        if(pro % t == 0)break;
        n++;
      }
      return n;
    }
}