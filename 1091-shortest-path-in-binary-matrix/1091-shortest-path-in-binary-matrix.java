class Solution { 
    public int n;
    public int[][] grid;
    public int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= n;
    }

    public int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[] {y, x, 1});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            
            if (point[0] == n - 1 && point[1] == n - 1) {
                return point[2]; 
            }

            for (int i = 0; i < 8; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || grid[ny][nx] != 0) {
                    continue;
                }

                q.add(new int[] {ny, nx, point[2] + 1});
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
       n = grid.length;
       this.grid = grid;

       if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
           return -1;
       }
    
       return bfs(0, 0);
    }
}