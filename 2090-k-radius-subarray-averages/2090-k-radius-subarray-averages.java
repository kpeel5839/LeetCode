class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] sum = new long[nums.length];
        int[] ans = new int[nums.length];
        sum[0] = nums[0];
                            
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        
        Arrays.fill(ans, -1);
        
        for (int i = k; i <= nums.length - 1 - k; i++) {
            long minus = i - k - 1 < 0 ? 0 : sum[i - k - 1];
            
            ans[i] = (int) ((sum[i + k] - minus) / (k * 2 + 1));
        }
        
        return ans;
    }
}