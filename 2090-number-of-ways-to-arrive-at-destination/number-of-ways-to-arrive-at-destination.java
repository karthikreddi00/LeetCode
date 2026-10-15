class Solution {

    public static class pair{
        int e;
        long w;
        pair(int e, long w){
            this.e = e;
            this.w = w;
        }
    }

    public static int dijkstra(ArrayList<pair>[] g, int n){

        long mod = (long) 1e9 + 7;
        PriorityQueue<pair> q = new PriorityQueue<>((a,b)-> Long.compare(a.w, b.w));
        long[] path = new long[n];
        long[] ways = new long[n];

        Arrays.fill(path, Long.MAX_VALUE);

        path[0] = 0;
        ways[0] = 1;
        q.add(new pair(0, 0));

        while(!q.isEmpty()){
            pair tem = q.poll();
            if(tem.w > path[tem.e]) continue;
            for(pair val : g[tem.e]){
                if(val.w + tem.w < path[val.e]){
                    path[val.e] = val.w + tem.w;
                    ways[val.e] = ways[tem.e];
                    q.add(new pair(val.e, path[val.e]));
                }else if(val.w + tem.w == path[val.e]){
                    ways[val.e] = (ways[val.e] + ways[tem.e]) % mod;
                }
            }
        }
        return (int)ways[n - 1];
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<pair>[] g = new ArrayList[n];
        for(int i = 0; i < n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 0; i < roads.length; i++){
                int v = roads[i][0];
                int u = roads[i][1];
                int w = roads[i][2];
                g[v].add(new pair(u, w));
                g[u].add(new pair(v, w));
        }

       return dijkstra(g,n);
    }
}