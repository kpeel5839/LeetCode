class Solution {
    public int maxProfit(int[] prices) {
        Deque<Integer> q = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < prices.length; i++) {
            while (!q.isEmpty() && q.peekLast() > prices[i]) {
                q.pollLast();
            }

            q.addLast(prices[i]);
            answer = Math.max(answer, q.peekLast() - q.peekFirst());
        }

        return answer;
    }
}