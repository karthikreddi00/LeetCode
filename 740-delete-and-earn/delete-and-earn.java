class Solution {

  public static int  recursive(int[] sum,int max){
        if(max <= 0) return 0;

        int take = recursive(sum, max - 1);
        int dontake = sum[max] +  recursive(sum, max - 2);
       return Math.max(take, dontake);
    }

    public static int memorization(int[] sum, int max, int [] dp){
        if(max <= 0) return 0;
        if(dp[max] != -1) return dp[max];
        int take = memorization(sum, max - 1, dp);
        int dontake = sum[max] +  memorization(sum, max - 2, dp);
       dp[max] = Math.max(take, dontake);
        return dp[max];
    }

    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            max = Math.max(max, val);
        }
        int[] sum = new int[max + 1];
        for(int val : nums){
            sum[val] += val;
        }
        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);
      return  memorization(sum, max, dp);
    }
}