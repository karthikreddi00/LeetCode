class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}