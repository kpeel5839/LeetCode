class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] ans = new int[nums.length - k + 1];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            count++;

            if (k <= count) {
                while (m.get(q.peek()) == 0) {
                    q.poll(); 
                }
                
                ans[i - k + 1] = q.peek();
                m.put(nums[i - k + 1], m.get(nums[i - k + 1]) - 1);
            }
        }

        return ans;
    }
}