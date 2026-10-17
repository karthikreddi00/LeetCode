class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] a = new int[n][3];
        for(int i = 0; i < n; i++){
            int val = nums[i];
            int sum = 0;
            while(val > 0){
                sum += val % 10;
                val /= 10;
            }
            a[i][0] = sum;
            a[i][1] = nums[i];
            a[i][2] = i;
        }
        Arrays.sort(a, (x, y) -> {
            return (x[0] != y[0])
             ? Integer.compare(x[0], y[0]) 
             : Integer.compare(x[1], y[1]);
        });

        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] || a[i][2] == i) continue;
            int j = i;
            int len = 0;
            while(!visited[j]){
                visited[j] = true;
                j = a[j][2];
                len++;
            }
            ans += len - 1;
        }
        return ans;
    }
}