class MedianFinder {
    
    public PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public PriorityQueue<Integer> min = new PriorityQueue<>();

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        int size = max.size() + min.size();

        if (size % 2 == 1) {
            if (num < max.peek()) {
                min.add(max.poll());
                max.add(num);
            } else {
                min.add(num);
            }
        } else {
            if (!min.isEmpty() && min.peek() < num) {
                max.add(min.poll());
                min.add(num);
            } else {
                max.add(num);
            }
        }
    }
    
    public double findMedian() {
        int size = max.size() + min.size();

        if (size % 2 == 1) {
            return max.peek();
        } else {
            return (double) (min.peek() + max.peek()) / 2d;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */