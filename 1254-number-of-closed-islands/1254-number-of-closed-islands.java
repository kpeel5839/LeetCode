class Solution {
    public boolean[][] v;
    public int[][] g;
    public int[] dx = new int[] {0, 1, 0, -1};
    public int[] dy = new int[] {-1, 0, 1, 0};
    
    public boolean isOut(int y, int x) {
        return (y < 0 || y >= g.length) || (x < 0 || x >= g[0].length);    
    }
    
    public void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        v[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                
                if (isOut(ny, nx) || v[ny][nx] || g[ny][nx] == 1) {
                    continue;
                }
                
                v[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }
    }
    
    public int closedIsland(int[][] grid) {
        v = new boolean[grid.length + 2][grid[0].length + 2];
        g = new int[v.length][v[0].length];
        
        for (int i = 1; i < g.length - 1; i++) {
            for (int j = 1; j < g[i].length - 1; j++) {
                g[i][j] = grid[i - 1][j - 1];            
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < g.length; i++) {
            for (int j = 0 ; j < g[i].length; j++) {
                if (!v[i][j] && g[i][j] == 0) {
                    ans++;
                    bfs(i, j);
                }
            }
        }
        
        return ans - 1;
    }
}