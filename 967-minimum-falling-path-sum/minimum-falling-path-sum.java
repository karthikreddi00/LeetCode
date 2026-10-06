class Solution {

  public static int recursive(int[][] matrix, int i, int j, int n, int m){
          if(i >= n || j >= m || j < 0) return Integer.MAX_VALUE;
          if(i == n - 1) return matrix[i][j];
          int left = recursive(matrix, i + 1, j - 1, n, m);
          int down = recursive(matrix, i + 1, j, n, m);
          int right = recursive(matrix, i + 1, j + 1, n, m);
          return matrix[i][j] + Math.min(left,Math.min(down, right));
  }

  public static int memorization(int[][] matrix, int i, int j, int n, int m, Integer[][] dp){
          if(i >= n || j >= m || j < 0) return Integer.MAX_VALUE;
          if(i == n - 1) return matrix[i][j];
          if(dp[i][j] != null) return dp[i][j];
          int left = memorization(matrix, i + 1, j - 1, n, m, dp);
          int down = memorization(matrix, i + 1, j, n, m, dp);
          int right = memorization(matrix, i + 1, j + 1, n, m, dp);
        dp[i][j] =  matrix[i][j] + Math.min(left,Math.min(down, right));
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