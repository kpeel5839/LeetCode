class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        
        for (int i = 0; i < nums.length / 2; i++) {
            ans = Math.max(ans, nums[nums.length - i - 1] + nums[i]);
        }
        
        return ans;
    }
}