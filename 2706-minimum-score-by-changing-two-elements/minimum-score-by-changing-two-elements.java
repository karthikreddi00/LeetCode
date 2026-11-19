class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n - 1] - nums[2];
        max = Math.min(nums[n - 3] - nums[0], max);
        max = Math.min(nums[n - 2] - nums[1], max);
        return max;
    }
}