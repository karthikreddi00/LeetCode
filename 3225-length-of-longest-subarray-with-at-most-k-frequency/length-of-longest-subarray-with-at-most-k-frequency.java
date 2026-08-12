class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;
        int j = 0;
       while( i < n && j < n){
        map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        while(map.get(nums[j]) > k){
            if(map.get(nums[i]) == 1) map.remove(nums[i]);
            else map.put(nums[i], map.get(nums[i]) - 1);
            i++;
        }
        j++;
        ans = Math.max(ans, j - i);
       }
       return ans;
    }
}