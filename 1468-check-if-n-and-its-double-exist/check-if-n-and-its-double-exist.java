class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr){
            if(set.contains(val * 2) || ((val % 2 == 0)? set.contains(val / 2) : false)) return true;
            set.add(val);
        }
        return false;
    }
}