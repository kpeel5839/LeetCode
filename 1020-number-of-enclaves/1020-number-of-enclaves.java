class Solution {
    public int[][] g;
    public boolean[][] v;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    
    public boolean isOut(int y, int x) {
        return (y < 0 || y >= g.length) || (x < 0 || x >= g[0].length);    
    }
    
    public int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y, x});
        v[y][x] = true;    
        int count = 0;
        boolean not = false;
    
        while (!q.isEmpty()) {
            int[] p = q.poll();
            count++;
            
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                
                if (isOut(ny, nx)) {
                    not = true;
                    continue;
                }
                
                if (v[ny][nx] || g[ny][nx] == 0) {
                    continue;
                }
                
                q.add(new int[] {ny, nx});
                v[ny][nx] = true;
            }
        }
        
        if (not) {
            return 0;    
        } 
        
        return count;
    }
    
    public int numEnclaves(int[][] grid) {
        g = grid;
        v = new boolean[g.length][g[0].length];
        
        int ans = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (!v[i][j] && g[i][j] == 1) {
                    ans += bfs(i, j);
                }
            }
        }
        
        return ans;
    }
}