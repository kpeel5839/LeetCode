class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        long value = nums[nums.length - 1];

        for (int i = nums.length - 2; 0 <= i; i--) {
            if (nums[i] < value) {
                value = nums[i];
                continue;
            }

            long count = (long) Math.ceil((double) nums[i] / (double) value);
            ans += (count - 1);
            value = (long) Math.floor((double) nums[i] / (double) count);
        }

        return ans;
    }
}