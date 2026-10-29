class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int l = 1;
        int h = 1000000;
        while(l <= h){
            int mid = l + (h - l) / 2;
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += nums[i] / mid;
                if(nums[i] % mid != 0) sum++;
            }
               if(sum > threshold){
                   l = mid + 1;
               }else{
                h = mid - 1;
                ans = Math.min(ans, mid);
               }
        }
        return ans;
    }
}