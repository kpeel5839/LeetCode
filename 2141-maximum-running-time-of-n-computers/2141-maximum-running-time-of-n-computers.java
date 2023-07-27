class Solution {
    public int n;
    public int[] b;
    
    public boolean isPossible(long m) {    
        int index = 0;
        long now = 0;

        for (int i = 0; i < b.length; i++) {
            if (n - index > b.length - i) {
                return false;
            }

            now += b[i];
            
            if (m <= now) {
                now %= m;
                index++;
            }

            if (index == n) {
                return true;
            }
        }

        return false;
    }
    
    public long maxRunTime(int n, int[] batteries) {
        this.n = n;
        this.b = batteries;
        Arrays.sort(b);
        long l = 0;
        long r = (long) Math.pow(10, 14); 
        long ans = 0;

        while (l <= r) {
            long m = (l + r) / 2;

            if (isPossible(m)) {
                ans = m;
                l = m + 1; 
            } else {
                r = m - 1;
            }
        }
        
        return ans;
    }
}