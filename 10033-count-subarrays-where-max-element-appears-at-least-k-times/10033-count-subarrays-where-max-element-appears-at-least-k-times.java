class Solution {
    public long countSubarrays(int[] nums, int k) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            m.computeIfAbsent(nums[i], ignored -> new ArrayList<>()).add(i);
        }
       
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        long answer = 0;
        int last = -1;
        
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            
            if (max == nums[i] && k <= count.get(nums[i])) {
                last = Math.max(last, m.get(nums[i]).get(count.get(nums[i]) - 1 - (k - 1)));
            }
            
            if (last != -1) {
                answer += last + 1;
            }
        }
        
        return answer;
    }
}