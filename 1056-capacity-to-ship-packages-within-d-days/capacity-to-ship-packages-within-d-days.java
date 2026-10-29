class Solution {
    public int shipWithinDays(int[] nums, int threshold) {
       int n = nums.length;
       int l = Arrays.stream(nums).max().getAsInt();
       int h = Arrays.stream(nums).sum();
        while(l <= h){
            int mid = l + (h - l) / 2;
            int sum = 0;
            int days = 0;
            for(int i = 0; i < n; i++){
                 if(sum + nums[i] > mid){
                    days++;
                    sum = 0;
                 }
                 sum += nums[i];
            }
            days++;
               if(days > threshold){
                   l = mid + 1;
               }else{
                h = mid - 1;
               }
        }
        return l;
    }
}