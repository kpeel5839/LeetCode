class Solution {
    public int moduler(int sum, int k) {
        int value = sum % k;
        
        if (value < 0) {
            return k + value;
        }
        
        return value;
    }
    
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int answer = 0;
        int sum = 0;
        frequency.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remain = moduler(sum, k);
            answer += frequency.getOrDefault(remain, 0);
            frequency.put(remain, frequency.getOrDefault(remain, 0) + 1);        
        }
        
        return answer;
    }
}