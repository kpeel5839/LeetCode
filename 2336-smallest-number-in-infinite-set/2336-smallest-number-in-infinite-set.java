class SmallestInfiniteSet {
    public int n;
    public PriorityQueue<Integer> q;    
    public Set<Integer> s;

    public SmallestInfiniteSet() {
        n = 1;
        q = new PriorityQueue<>();        
        s = new HashSet<>();
    }
    
    public int popSmallest() {
        while (!q.isEmpty() && q.peek() < n) {
            int v = q.poll();
            s.remove(v);
            return v;
        }
        
        return n++;
    }
    
    public void addBack(int num) {
        if (!s.contains(num) && num < n) {
            q.add(num);         
            s.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */