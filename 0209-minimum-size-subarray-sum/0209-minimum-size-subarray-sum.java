class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0; 
        int l = 0; 
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (target <= sum) {
                if (i == l) {
                    return 1;
                }

                ans = Math.min(ans, i - l + 1);
                sum -= nums[l++];
            }
        } 
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}