class Solution {
    public int maximumScore(int[] nums, int k) {
        int min = nums[k];
        int ans = min;
        int l = k;
        int r = k;

        while ((r - l + 1) != nums.length) {
            int left = (l == 0 ? 0 : nums[l - 1]);
            int right = (r == nums.length - 1 ? 0 : nums[r + 1]);
            
            if (right <= left) {
                min = Math.min(min, left);
                l--;
            } else {
                min = Math.min(min, right);
                r++;
            }
            
            ans = Math.max(ans, min * (r - l + 1));
        }
        
        return ans;
    }
}