class Solution {

    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minid = 0;
        int maxid = 0;

        for(int i = 0; i < n; i++){

            if(min > nums[i]){
                min = nums[i];
                minid = i;
            }

            if(max < nums[i]){
                max = nums[i];
                maxid = i;
            }
        }

        int ans = 0;
        int left = Math.min(minid, maxid);
        int right = Math.max(minid, maxid);
        int front = right + 1;
        int back = n - left;
        int both = (left + 1) + (n - right);

        ans = Math.min(front, Math.min(back, both));

        return ans;
    }
}