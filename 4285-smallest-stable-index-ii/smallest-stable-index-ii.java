class Solution {
    public int firstStableIndex(int[] nums, int k) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        PriorityQueue<Integer> min  = new PriorityQueue<>();
        for(int val : nums){
            min.add(val);
        }
        int len = nums.length;
        if(len==1){
            return (nums[0]-nums[0]<=k)? 0: -1;
        }
        int i = 0;
        max.add(nums[0]);
        Map<Integer,Integer> map = new HashMap<>();
        while(i < len){
            int sub = max.peek()-min.peek();
            if(sub<=k){
                return i;
            }
            i++;
            if(i>=len){
                break;
            }
            max.add(nums[i]);
            map.put(nums[i-1],map.getOrDefault(nums[i-1],0)+1);
            while(map.containsKey(min.peek())){
                int val = map.get(min.peek());
                if(val>1){
                    map.put(min.peek(),val-1);
                }else {
                    map.remove(min.peek());
                }
                min.poll();
            }
        }
        return -1;
    }
}