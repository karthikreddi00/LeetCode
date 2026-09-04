class Solution {
    public int firstStableIndex(int[] nums, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        int n =  nums.length;
        if(n==1) {
            return (nums[0]-nums[0]<=k)? 0:-1;
        }
        for(int i = 0; i < n; i++){
            min.add(nums[i]);
        }
        max.add(nums[0]);
        int ind = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(ind<n){
            int ch = max.peek()-min.peek();
            if(ch<=k){
                return ind;
            }
            ind++;
            if(ind>=n){
                break;
            }
            max.add(nums[ind]);
            map.put(nums[ind-1],map.getOrDefault(nums[ind-1],0)+1);
           while(map.containsKey(min.peek())){
               if(map.get(min.peek())>1){
                   map.put(min.peek(),map.get(min.peek())-1);
               }else{
                   map.remove(min.peek());
               }
               min.poll();
           }
        }
        return -1;
    }
}