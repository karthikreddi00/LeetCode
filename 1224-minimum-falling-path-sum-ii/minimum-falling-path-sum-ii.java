class Solution {

  public static int memorization(int[][] matrix, int i, int j, int n, int m, Integer[][] dp){
          if(i >= n || j >= m || j < 0) return Integer.MAX_VALUE;
          if(i == n - 1) return matrix[i][j];
          if(dp[i][j] != null) return dp[i][j];
          int min = Integer.MAX_VALUE;
         for(int x = 0; x < m; x++){
            if(x == j) continue;
             int tem = memorization(matrix, i + 1, x, n, m, dp);
             min = Math.min(min, tem);
         }
        dp[i][j] =  matrix[i][j] + min;
        return dp[i][j];
  }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        Integer[][] dp = new Integer[n][m];
       for(int i = 0; i < m; i++){
            ans = Math.min(ans, memorization(matrix, 0, i, n, m, dp));
       }
     return   ans;
    }
}