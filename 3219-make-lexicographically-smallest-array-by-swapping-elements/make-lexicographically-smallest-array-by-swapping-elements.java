class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sort = nums.clone();
        Arrays.sort(sort);
        int n = nums.length;
        int[] ans = new int[n];
        Map<Integer, List<Integer>> group = new HashMap<>();
        Map<Integer, Integer> id = new HashMap<>();
        Map<Integer, Integer> pos = new HashMap<>();
        int i = 1;
        id.put(sort[0], i);
        List<Integer> temp = new ArrayList<>();
        temp.add(sort[0]);
        for(int j = 1; j < n; j++){
           if(sort[j] - sort[j - 1] <= limit){
            temp.add(sort[j]);
           }else{
            group.put(i, new ArrayList<>(temp));
            temp = new ArrayList<>();
            temp.add(sort[j]);
            i++;
           }
           id.put(sort[j], i);
        }
        group.put(i, new ArrayList<>(temp));

       for(int j = 0; j < n; j++){
        int ids = id.get(nums[j]);
        int posin = 0;
        if(pos.containsKey(ids)){
            posin = pos.get(ids);
            pos.put(ids, posin + 1);
        }else{
            pos.put(ids, 1);
        }
         List<Integer> find = new ArrayList<>();
         find = group.get(ids);
         ans[j] = find.get(posin);
       }
        return ans;
    }
}