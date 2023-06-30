class Solution {
    
    public int[][] cells;
    public int row;
    public int col;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= row || x < 0 || x >= col; 
    }

    public boolean bfs(int day) {
        boolean[][] map = new boolean[row][col];
        for (int i = 0; i <= day; i++) {
            map[cells[i][0] - 1][cells[i][1] - 1] = true; 
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            if (!map[0][i]) {
                q.add(new int[] {0, i});
                visited[0][i] = true;
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0] == (row - 1)) {
                return true;
            } 

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if (outOfRange(ny, nx) || visited[ny][nx] || map[ny][nx]) {
                    continue;
                }

                q.add(new int[] {ny, nx});
                visited[ny][nx] = true;
            }
        } 

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.cells = cells;
        this.row = row;
        this.col = col;

        int l = 0;
        int r = cells.length;
        int ans = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            
            if (bfs(m)) {
                l = m + 1; 
                ans = m + 1;
            } else {
                r = m - 1; 
            }
        }
        
        return ans;
    }
}