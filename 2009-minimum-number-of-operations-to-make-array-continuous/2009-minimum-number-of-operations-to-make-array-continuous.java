class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        int r = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            while (r != n && (nums[r] - nums[i]) <= (n - 1)) {
                m.put(nums[r], m.getOrDefault(nums[r], 0) + 1);
                r++;
            }
            
            int count = r - i + 1;
            ans = Math.min(ans, n - m.size());
            m.put(nums[i], m.get(nums[i]) - 1);

            if (m.get(nums[i]) == 0) {
                m.remove(nums[i]);
            }
        }

        return ans;
    }
}