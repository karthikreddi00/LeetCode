class Solution {
    static class pair{
        int r;
        int s;
        pair(int r, int s){
            this.r = r;
            this.s = s;
        }
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans = 0;
        List<pair> list = new ArrayList<>();
        for(int []a : reservedSeats){
               list.add(new pair(a[0],a[1]));
        }
        Collections.sort(list, (x, y) -> {
            if(x.r != y.r){
               return x.r - y.r;
            }else {
                return x.s - y.s;
            }
        });
        boolean two = true;
        boolean four = true;
        boolean six = true;
        int num = 1;
        int diff = 1;
        for(pair val : list){
            int r = val.r;
            int s = val.s;
          //  System.out.println(r+" "+s);
            if(r != num){
                diff++;
                if(two && four && six){
                    ans+=2;
                }else if(two && four){
                  ans++;
                }else if(four && six){
                    ans++;
                }else if(two){
                    ans++;
                }else if(four){
                    ans++;
                }else if(six){
                    ans++;
                }
                two = true;
                four = true;
                six = true;
                num = r;
            }
            if(s >= 2 && s <=5) two = false;
            if(s >= 4 && s <= 7) four = false;
            if(s >= 6 && s <= 9) six = false;
        }
       
                if(two && four && six){
                    ans+=2;
                }else if(two && four){
                  ans++;
                }else if(four && six){
                    ans++;
                }else if(two){
                    ans++;
                }else if(four){
                    ans++;
                }else if(six){
                    ans++;
                }
    int sub = n - diff;
        ans += sub * 2;
        return ans;
    }
}