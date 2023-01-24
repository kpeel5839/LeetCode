class Solution {
    public int n;
    public int[] convertPosition(int index) {
        int y = (int) Math.ceil((float) index / n);
        int x = 0;
        
        if (y % 2 == 0) { // 오른쪽 --> 왼쪽 (n - 1 에서 시작)
            x = n - 1 - ((index - 1) % n);
        } else { // 왼쪽 --> 오른쪽 (0 에서 시작)
            x += ((index - 1) % n);
        }
        
        return new int[] {n - y, x};
    }
    
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        int limit = (int) Math.pow(n, 2);
        boolean[] visited = new boolean[limit + 1];
        Queue<int[]> queue = new LinkedList<>(); // {index, value}
        visited[1] = true;
        queue.add(new int[] {1, 0});
        
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            
            System.out.println(Arrays.toString(point));
            
            if (point[0] == limit) {
                return point[1];
            }
            
            for (int i = point[0] + 1; i <= Math.min(point[0] + 6, limit); i++) {
                int[] nextPosition = convertPosition(i);                   
                
                if (visited[i]) {
                    continue;
                }        
                
                if (board[nextPosition[0]][nextPosition[1]] != -1) {                                        
                    if (visited[board[nextPosition[0]][nextPosition[1]]]) {
                        continue;
                    }
                    
                    visited[i] = true;
                    queue.add(new int[] {board[nextPosition[0]][nextPosition[1]], point[1] + 1});
                }
                
                if (board[nextPosition[0]][nextPosition[1]] == -1) {
                    visited[i] = true;
                    queue.add(new int[] {i, point[1] + 1});                
                }
            }
        }
        
        return -1;
    }
}