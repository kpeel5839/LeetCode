class SmallestInfiniteSet {
    public int n;
    public PriorityQueue<Integer> q;    

    public SmallestInfiniteSet() {
        n = 1;
        q = new PriorityQueue<>();        
    }
    
    public int popSmallest() {
        while (!q.isEmpty() && q.peek() < n) {
            int v = q.poll();
            
            if (!q.isEmpty() && q.peek() == v) {
                continue;
            }
            
            return v;
        }
        
        return n++;
    }
    
    public void addBack(int num) {
        if (num < n) {
            q.add(num);            
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */