class Solution {
    public int[] n;
    public boolean is(int m) {
        long pre = n[0];
        
        if (m < pre) {
            return false;
        }
        
        for (int i = 1; i < n.length; i++) {
            long now = n[i];
            
            long diff = m - pre;
            pre += diff;
            now -= diff;
            
            if (m < now) {
                return false;
            }
            
            pre = now;
        }
        
        return true;
    }
    
    public int minimizeArrayValue(int[] nums) {
        int right = (int) Math.pow(10, 9);
        int left = 0;
        n = nums;
        int ans = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;            
            
            if (is(mid)) {
                ans = mid;
                right = mid - 1;
            } else {        
                left = mid + 1;
            }
        }
        
        return ans;
    }
}