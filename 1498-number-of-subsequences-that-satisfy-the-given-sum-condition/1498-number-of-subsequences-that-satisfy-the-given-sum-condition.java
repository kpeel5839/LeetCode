class Solution {
    public int MOD = (int) Math.pow(10, 9) + 7;
    public long[] pp;
    
    public void ppp(int n) {
        pp = new long[n];
        pp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            pp[i] = (pp[i - 1] * 2) % MOD;
        }
    }
    
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);    
        ppp(nums.length);
        int r = nums.length - 1;
        long ans = 0L;
        
        for (int i = 0; i < nums.length; i++) {                    
            while (0 <= r && target < nums[i] + nums[r]) {
                r--;
            }
            
            if (r - i < 0) {
                break;
            }
                    
            ans += (pp[r - i]) % MOD;                        
        }
        
        return (int) (ans % MOD);
    }
}