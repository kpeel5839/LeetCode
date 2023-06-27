class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] ans = new int[nums.length - (k - 1)];
        
        for (int i = 1; i <= nums.length; i++) {
            q.add(nums[i - 1]);
            m.put(nums[i - 1], m.getOrDefault(nums[i - 1], 0) + 1);
            
            if (k <= i) {
                while (true) {
                    int value = q.peek();
                    
                    if (m.get(value) == 0) {
                        q.poll(); 
                        continue;
                    }
                   
                    ans[i - k] = value;
                    break;
                }
                
                m.put(nums[i - k], m.get(nums[i - k]) - 1);
            }
        }
        
        return ans;
    }
}