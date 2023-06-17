class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
      
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != min && nums[i] != max) {
                return nums[i];
            }
        }
        
        return -1;
    }
}