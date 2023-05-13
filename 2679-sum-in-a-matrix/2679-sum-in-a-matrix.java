class Solution {
    public int matrixSum(int[][] nums) {
        PriorityQueue[] q = new PriorityQueue[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            q[i] = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
            
            for (int j = 0; j < nums[i].length; j++) {
                q[i].add(nums[i][j]);
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < nums[0].length; i++) {
            int m = 0;
            
            for (int j = 0; j < nums.length; j++) {
                m = Math.max(m, (int) q[j].poll());
            }
            
            ans += m;
        }
        
        return ans;
    }
}