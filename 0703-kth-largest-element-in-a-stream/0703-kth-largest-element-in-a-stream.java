class KthLargest {
    
    public PriorityQueue<Integer> min;
    public PriorityQueue<Integer> max;
    public int k;

    public KthLargest(int k, int[] nums) {
        min = new PriorityQueue<>((o1, o2) -> o1 - o2);
        max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        this.k = k;
        
        for (int i = 0; i < nums.length; i++) {
            min.add(nums[i]);
        }
        
        while (k < min.size()) {
            max.add(min.poll());
        }
    }
    
    public int add(int val) {
        if (min.isEmpty() || min.size() < k) {
            min.add(val);
        } else if (min.peek() < val) {
            max.add(min.poll());
            min.add(val);    
        } else {
            max.add(val);
        }
        
        return min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */