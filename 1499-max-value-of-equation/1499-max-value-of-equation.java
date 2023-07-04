class Solution {

    public int cal(int[] point1, int[] point2) { // left 
        return point1[1] + point2[1] + (point1[0] - point2[0]);
    }

    public int findMaxValueOfEquation(int[][] points, int k) {
        int l = 0;
        int ans = Integer.MIN_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> (o2[1] - o2[0]) - (o1[1] - o1[0]));
        q.add(points[0]);
        
        for (int i = 1; i < points.length; i++) {
            while (!q.isEmpty() && k < (points[i][0] - q.peek()[0])) {
                q.poll(); 
            }
            
            if (!q.isEmpty()) {
                ans = Math.max(ans, cal(points[i], q.peek()));
            }

            q.add(points[i]);
        }
        
        return ans;
    }
    
}