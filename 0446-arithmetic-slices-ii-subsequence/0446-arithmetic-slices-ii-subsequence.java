class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Map<Long, Integer>[] m = new HashMap[n];
        m[0] = new HashMap<>();
        
        for (int i = 1; i < n; i++) {
            m[i] = new HashMap<>();
            
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                int count = m[j].getOrDefault(diff, 0);
                answer += count;
                m[i].put(diff, m[i].getOrDefault(diff, 0) + count + 1);
            }
        }
        
        return answer;
    }
}