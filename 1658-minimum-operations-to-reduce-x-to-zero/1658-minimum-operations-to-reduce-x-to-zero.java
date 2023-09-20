class Solution {
    public int minOperations(int[] nums, int x) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum == x) {
            ans = nums.length;
        }

        int r = nums.length - 1;

        for (int i = nums.length - 1; 0 <= i; i--) {
            sum -= nums[i];
            
            while (sum < x && i < r) {
                sum += nums[r];
                r--;
            }

            if (sum == x) {
                ans = Math.min(ans, i + (nums.length - (r + 1)));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}