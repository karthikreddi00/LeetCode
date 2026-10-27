class Solution {
    public String[] createGrid(int m, int n) {
        int[][] ans = new int[m][n];
        for(int i = 0; i < n; i++){
            ans[m - 1][i] = 1;
        }
        for(int i = 0; i < m; i++){
            ans[i][0] = 1;
        }
        String[] sol = new String[m];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(ans[i][j] == 1) sb.append('.');
                else sb.append('#');
            }
           sol[i] = sb.toString();
           sb = new StringBuilder();
        }
        return sol;
    }
}