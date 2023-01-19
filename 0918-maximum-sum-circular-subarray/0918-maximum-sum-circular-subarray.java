class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int max = maxSum;
        int min = minSum;
        
        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            
            if (maxSum <= 0) {
                maxSum = nums[i];
            } else {
                maxSum += nums[i];
            }
            
            if (minSum < 0) {
                minSum += nums[i];
            } else {
                minSum = nums[i];
            }
            
            min = Math.min(min, minSum);
            max = Math.max(max, maxSum);
        }
        
        if (totalSum == min) {
            return max;
        }
        
        return Math.max(max, (totalSum - min));
    }
}