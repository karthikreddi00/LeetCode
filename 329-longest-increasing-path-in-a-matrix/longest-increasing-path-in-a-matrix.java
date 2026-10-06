class Solution {

    public static int dfs(int[][] a, int i, int j, int n, int m, int[][] dp){
         if(dp[i][j] != 0) return dp[i][j];
         //up
         int best = 1;
         if(i > 0 && i < n && a[i - 1][j] > a[i][j]){
             best = Math.max(best, 1 + dfs(a, i - 1, j, n, m, dp));
         }
         //right
         if(j >= 0 && j < m -1 && a[i][j + 1] > a[i][j]){
            best = Math.max(best, 1 + dfs(a, i, j + 1, n, m, dp));
         }
         //down
         if(i >=0 && i < n -1 && a[i + 1][j] > a[i][j]){
            best = Math.max(best, 1 + dfs(a, i + 1, j, n, m, dp));
         }
         //left
         if( j > 0 && j < m && a[i][j - 1] > a[i][j]){
            best = Math.max(best, 1 + dfs(a, i, j - 1, n, m, dp));
         }
         dp[i][j] = best;
         return dp[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        int ans = Integer.MIN_VALUE;
        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, dfs(matrix, i, j, n, m, dp));
            }
        }
        return ans;
    }
}