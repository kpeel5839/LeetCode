class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        double value = nums[nums.length - 1];

        for (int i = nums.length - 2; 0 <= i; i--) {
            if (nums[i] < value) {
                value = nums[i];
                continue;
            }

            double count = (int) Math.ceil(nums[i] / value);
            ans += (count - 1);
            value = (int) Math.floor(nums[i] / count);
        }

        return ans;
    }
}