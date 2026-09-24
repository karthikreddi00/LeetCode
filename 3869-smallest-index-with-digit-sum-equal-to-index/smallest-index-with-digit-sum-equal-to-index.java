class Solution {

    public static int sum(int val){
        int ans = 0;
        while(val > 0){
            int rem = val % 10;
            ans += rem;
            val /= 10;
        }
        return ans;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
         for(int i = 0 ; i < n; i++){
            if(i  == sum(nums[i])){
                ans = Math.min(ans, i);
            }
         }
         return ((ans == Integer.MAX_VALUE)? -1 : ans);
    }
}