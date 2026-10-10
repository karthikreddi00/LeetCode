class Solution {

    public static int bf(int[] a, int n, int max, int k1, int k2){
           long l = 0;
           long h = max;
           int ans = max;
           long tar = k1 + k2;
           while(l <= h){
            long mid = l + (h - l)/2;
            long sum = 0;
            for(int i = 0; i < n; i++){
                sum += ((a[i] - mid) > 0)? a[i] - mid : 0;
            }
            if(sum <= tar){
                ans = (int)(mid);
                 h = mid - 1;
            }else{
                l = mid + 1;
            }
           }
           return ans;
    }
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int[] dif = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            dif[i] = Math.abs(nums1[i] - nums2[i]);
            q.add(dif[i]);
            max = Math.max(max, dif[i]);
        }
         long k = (long) k1 + k2;
        long total = 0;
        for (int d : dif) {
            total += d;
        }
        if (total <= k) {
            return 0;
        }
        int reduce = bf(dif, n, max, k1, k2);
        long used = 0;
        for (int d : dif) {
            used += Math.max(0, d - reduce);
        }
        long remaining = k - used;
        long ans = 0;
        for (int d : dif) {
            long x = Math.min(d, reduce);
            if (x == reduce && remaining > 0 && x > 0) {
                x--;
                remaining--;
            }
            ans += x * x;
        }
        return ans;
    }
}