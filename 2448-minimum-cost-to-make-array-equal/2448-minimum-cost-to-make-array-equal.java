class Solution {
    
    public int[] nums;
    public int[] cost;
    public long ans;
    public final int GO_RIGHT = 1;
    public final int GO_LEFT = 2;
    public final int STOP = 0;
    
    public int judge(long m) {
        ans = Math.min(ans, cal(m));
        long left = cal(m - 1);
        long right = cal(m + 1);

        if (left < right) {
            return GO_LEFT;
        } 

        if (right < left) {
            return GO_RIGHT;
        }

        return STOP;
    }

    public long cal(long m) {
        long result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            result += ((long) Math.abs((long) nums[i] - m) * (long) cost[i]);
        }
        
        return result;
    }

    public long minCost(int[] nums, int[] cost) {
        int l = 1;
        int r = 1_000_000;
        this.nums = nums;
        this.cost = cost;
        ans = Long.MAX_VALUE;

        while (l <= r) {
            int m = (l + r) / 2;
            int a = judge(m);
                
            if (a == GO_RIGHT) {
                l = m + 1;
            } else if (a == GO_LEFT) {
                r = m - 1;
            } else {
                return ans;
            }
        }

        return ans;
    }
}