class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        
        int answer = 0;
        
        for (Integer value : m.values()) {
            int min = Integer.MAX_VALUE;
            
            for (int i = 0; i <= value / 3; i++) {
                if (value < 3 * i) {
                    continue;
                }
                
                if ((value - 3 * i) % 2 != 0) {
                    continue;
                }
                
                min = Math.min(min, i + (value - 3 * i) / 2);
            }
            
            if (min == Integer.MAX_VALUE) {
                return -1;
            }
            
            answer += min;
        }
        
        return answer;
    }
}