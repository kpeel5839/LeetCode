class Solution {
    
    public double hour;
    public int[] dist;

    public boolean isPossible(int m) {
        double totalTime = 0d;
        
        for (int i = 0; i < dist.length - 1; i++) {
            totalTime += Math.ceil((double) dist[i] / (double) m);
        }

        totalTime += (double) dist[dist.length - 1] / (double) m;

        return totalTime <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        this.hour = hour;
        this.dist = dist;
        int ans = -1;
        int l = 1;
        int r = (int) Math.pow(10, 9); 
        
        while (l <= r) {
            int m = (l + r) / 2;

            if (isPossible(m)) {
                r = m - 1;
                ans = m; 
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

}