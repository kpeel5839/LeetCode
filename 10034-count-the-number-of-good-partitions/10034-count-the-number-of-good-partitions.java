class Solution {
    
    public final int MOD = 1_000_000_007;
    
    public int numberOfGoodPartitions(int[] nums) {
        int cut = 0;
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        
        Set<Integer> occur = new HashSet<>();
        int allOccur = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            occur.add(nums[i]);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            
            if (count.get(nums[i]).equals(m.get(nums[i]))) {
                allOccur++;
            }
            
            if (occur.size() == allOccur) {
                cut++;
            }
        }
        
        int answer = 1;
        for (int i = 0; i < cut; i++) {
            answer = (answer * 2) % MOD;
        }
        
        return answer;
    }
}