class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        Map<Integer, Integer> m = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            
            while (left != i && k < m.get(nums[i])) {
                m.put(nums[left], m.get(nums[left++]) - 1);
            }
            
            answer = Math.max(answer, i - left + 1);
        }
        
        return answer;
    }
}