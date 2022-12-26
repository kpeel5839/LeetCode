class Solution {
    public boolean isReachableLastIndex(int[] nums) {
        int maxJump = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxJump--;
            
            if (maxJump < 0) {
                return false;
            }
            
            maxJump = Math.max(maxJump, nums[i]);
        }
        
        return true;
    }
    
    public boolean canJump(int[] nums) {
        return isReachableLastIndex(nums);
    }
}