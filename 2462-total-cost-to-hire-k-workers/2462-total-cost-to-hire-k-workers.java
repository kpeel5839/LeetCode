class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int count = 0;

        for (int i = 0; i < candidates; i++) {
            if (count != costs.length) {
                left.add(costs[i]);
                count++;
            }

            if (count != costs.length) {
                right.add(costs[costs.length - 1 - i]);
                count++;
            }
        }

        long ans = 0;
        int l = left.size();
        int r = costs.length - 1 - right.size();
        
        while (k-- > 0) {
            int leftValue = Integer.MAX_VALUE;
            int rightValue = Integer.MAX_VALUE;
            
            if (!left.isEmpty()) {
                leftValue = left.peek();
            }

            if (!right.isEmpty()) {
                rightValue = right.peek(); 
            }

            if (leftValue <= rightValue) { 
                ans += left.poll();

                if (count < costs.length) {
                    left.add(costs[l++]);
                }
            } else {
                ans += right.poll();

                if (count < costs.length) {
                    right.add(costs[r--]);
                }
            }

            count++;
        }

        return ans;
    }
}