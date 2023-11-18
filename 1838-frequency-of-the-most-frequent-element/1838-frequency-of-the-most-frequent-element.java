class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = 1;
        int sum = 0;
        int left = 0;
        
        for (int i = 1; i < nums.length; i++) {
            sum += (nums[i] - nums[i - 1]) * (i - left);
            
            while (k < sum) {
                sum -= (nums[i] - nums[left]);
                left++;
            }

            answer = Math.max(answer, i - left + 1);
        }
        
        return answer;
    }
}