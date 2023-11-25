class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] answer = new int[nums.length];
        int[] sum = new int[nums.length];
        int n = nums.length;
        sum[0] = nums[0];
        
        for (int i = 1; i < n; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer[i] = sum[n - 1] - sum[0] - nums[0] * (n - 1);
            } else if (i == n - 1) {
                answer[i] = nums[i] * (n - 1) - sum[n - 2];
            } else {
                answer[i] = (nums[i] * i - sum[i - 1]) + (sum[n - 1] - sum[i] - nums[i] * (n - i - 1));
            }
        }
        
        return answer;
    }
}