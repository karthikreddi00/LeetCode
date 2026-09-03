class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
       int [] odd =new int [n];
        int [ ] even =new int [n];
        int od = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if((nums1[i]&1)==1){
                od=Math.min(od,nums1[i]);
            }
        }
        for(int i = 0; i < n; i++){
            if((nums1[i]&1)==1){
                odd[i]=1;
                if(od<nums1[i])
                    even[i]=1;
            }else{
                even[i] = 1;
                 if(od<nums1[i])
                     odd[i]=1;
            }
        }
        boolean s = true;
        boolean k = true;
        for(int i = 0; i < n; i++){
            if(odd[i]==0)
                s=false;
            if(even[i]==0)
                k=false;
        }
        return s||k;
    }
}