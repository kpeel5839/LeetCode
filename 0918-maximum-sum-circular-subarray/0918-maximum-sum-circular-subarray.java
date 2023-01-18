class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] maxSum = new int[nums.length];
        int[] minSum = new int[nums.length];
        int totalSum = nums[0];
        maxSum[0] = nums[0];
        minSum[0] = nums[0];
        int max = maxSum[0];
        int min = minSum[0];
        
        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            
            if (maxSum[i - 1] < 0) {
                maxSum[i] = nums[i];
            }
            
            if (maxSum[i - 1] >= 0) {
                maxSum[i] += maxSum[i - 1] + nums[i];
            }
            
            if (minSum[i - 1] > 0) {
                minSum[i] = nums[i];
            } 
            
            if (minSum[i - 1] <= 0) {
                minSum[i] = minSum[i - 1] + nums[i];    
            }
            
            min = Math.min(min, minSum[i]);
            max = Math.max(max, maxSum[i]);
        }
        
        if (totalSum == min) {
            return max;
        }
        
        return Math.max(max, (totalSum - min));
    }
}