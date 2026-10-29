class Solution {
    public static int binary(int[] piles, int b){
        int n = piles.length;
        int ans = Integer.MAX_VALUE;
        long l = 1;
        long h =  0;
        for(int val : piles){
            h = Math.max(h, val);
        }
        while(l <= h){
            long mid = (l + h)/2;
            long sum = 0;
            for(int i = 0; i < n; i++){
                sum += piles[i] / mid;
                if(piles[i] % mid != 0) sum++;
            }
            if(sum > b){
                l = mid + 1;
            }else{
                h = mid - 1;
                ans = Math.min(ans,(int) mid);
            }
        }
            return (int) ans;
    }
    public int minEatingSpeed(int[] piles, int h) {
        return binary(piles, h);
    }
}