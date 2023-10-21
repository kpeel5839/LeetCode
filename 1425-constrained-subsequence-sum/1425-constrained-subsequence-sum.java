class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int max = 0;

            while (!q.isEmpty()) {
                int[] p = q.peek();

                if (k < (i - p[0])) {
                    q.poll();
                } else {
                    max = p[1];
                    break;
                }
            }

            if (0 < nums[i] + max) {
                q.add(new int[] {i, nums[i] + max});
            }

            ans = Math.max(ans, nums[i] + max);
        }

        return ans;
    }
}