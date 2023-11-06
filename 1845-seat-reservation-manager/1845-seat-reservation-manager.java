class SeatManager {
    
    public int next;
    public PriorityQueue<Integer> q; 

    public SeatManager(int n) {
        next = 1;
        q = new PriorityQueue<>();
    }
    
    public int reserve() {
        if (q.isEmpty()) {
            return next++;
        }

        return q.poll();
    }
    
    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
    
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */