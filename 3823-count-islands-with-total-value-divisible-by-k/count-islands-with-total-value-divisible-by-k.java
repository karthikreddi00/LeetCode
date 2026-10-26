class Solution {
    public static boolean bfs(int i, int j, int k, int[][] a, int n, int m){
        long sum = 0;
        Queue<int[]> q = new LinkedList<>();
        sum += a[i][j];
        a[i][j] = 0;
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] tem = q.poll();
            if(tem[0] > 0 && a[tem[0] - 1][tem[1]] != 0){
                q.add(new int[]{tem[0] - 1, tem[1]});
                sum += a[tem[0] - 1][tem[1]];
                a[tem[0] - 1][tem[1]] = 0;
            }
            if(tem[0] < n - 1 && a[tem[0] + 1][tem[1]] != 0){
                q.add(new int[]{tem[0] + 1, tem[1]});
                sum += a[tem[0] + 1][tem[1]];
                a[tem[0] + 1][tem[1]] = 0;
            }
            if(tem[1] > 0 && a[tem[0]][tem[1] - 1] != 0){
                q.add(new int[]{tem[0], tem[1] - 1});
                sum += a[tem[0]][tem[1] - 1];
                a[tem[0]][tem[1] - 1] = 0;
            }
            if(tem[1] < m - 1 && a[tem[0]][tem[1] + 1] != 0){
                q.add(new int[]{tem[0], tem[1] + 1});
                sum += a[tem[0]][tem[1] + 1];
                a[tem[0]][tem[1] + 1 ] = 0;
            }
        }
        if(sum == 0) return false;
        if(sum % k == 0) return true;
        else return false;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                  if(grid[i][j] != 0){
                    if(bfs(i, j, k, grid, n, m)){
                        ans++;
                    }
                  }
            }
        }
        return ans;
    }
}