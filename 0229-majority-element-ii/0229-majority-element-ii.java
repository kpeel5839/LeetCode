class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int critical = (n / 3) + 1;
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            if (count.get(nums[i]) == critical) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}