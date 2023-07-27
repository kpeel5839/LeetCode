class Solution {
    public int n;
    public int[] b;
    
    public boolean isPossible(long m) {
        Queue<Long> q = new LinkedList<>();
        int index = 0;
        long now = 0;

        for (int i = 0; i < b.length; i++) {
            q.add((long) b[i]); 
        }
        
        while (!q.isEmpty()) {
            if (n - index > q.size()) {
                return false; 
            }
        
            now += q.poll();
            
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