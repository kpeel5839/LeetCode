class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Arrays.stream(stones).forEach(v -> q.add(v));
        
        while (1 < q.size()) {
            int a = q.poll();
            int b = q.poll();
            
            if (a != b) {
                q.add(Math.max(a, b) - Math.min(a, b));
            }
        }
        
        return q.isEmpty() ? 0 : q.peek();
    }
}