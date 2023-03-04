class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Set<Integer> set = new HashSet<>();
        int pivot = minK == maxK ? 1 : 2;
        Map<Integer, Integer> convert = new HashMap<>();
        Map<Integer, Integer> index = new HashMap<>();
        
        convert.put(minK, maxK);
        convert.put(maxK, minK);
        int outRange = -1;
        long answer = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (minK == nums[i] || maxK == nums[i]) {
                set.add(nums[i]);
                index.put(nums[i], i);
            }
            
            if (minK <= nums[i] && nums[i] <= maxK) {
                if (set.size() == pivot) {
                    if (minK == nums[i] || maxK == nums[i]) {
                        int reverse = convert.get(nums[i]);
                        max = Math.max(max, index.get(reverse) - outRange);
                        answer += index.get(reverse) - outRange;
                    } else {
                        answer += max;
                    }
                }
            } else {
                set.clear();
                index.clear();
                outRange = i;
                max = 0;
            }
        }
        
        return answer;
    }
}