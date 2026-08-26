class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<String> list = new ArrayList<>();
        int n  = s.length();
        int i = 0;
        int count = 0;
        int small = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        while(i < n){
            sb.append(s.charAt(i));
              if(s.charAt(i) == '1'){
                count++;
                if(k == 1){
                    return "1";
                }
              }
              if(count == k){
                while(sb.charAt(0)=='0'){
                    sb.deleteCharAt(0);
                }
                list.add(sb.toString());
                small = Math.min(small, sb.length());
              while(true){
                if(sb.charAt(0) == '1'){
                    count--;
                }
                if(count == k - 2) break;
                sb.deleteCharAt(0);
              }
              count++;
              }
              i++;
        }
        List<String> ans = new ArrayList<>();
        for(String val : list){
            if(val.length()==small){
                ans.add(val);
            }
        }
        Collections.sort(ans);
        System.out.println(small);
        return (list.size() == 0)? "" : ans.get(0);
    }
}