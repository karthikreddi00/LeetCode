class Solution {
    public long maxAlternatingSum(int[] nums) {
        int [] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=(nums[i]*nums[i]);
        }
        Arrays.sort(temp);
        long score=0;
        int len=(temp.length)/2;
        for(int i=temp.length-1;i>=len;i--){
            score+=temp[i];
        }
        for(int i=0;i<len;i++){
            score-=temp[i];
        }
        return score;
    }
}