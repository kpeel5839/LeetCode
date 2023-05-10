class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public boolean[][] v;
    public int[][] m;
    
    public boolean o(int y, int x) {
        return y < 0 || y >= m.length || x < 0 || x >= m[0].length;
    }
    
    public void dfs(int dir, int y, int x, int number) {
        v[y][x] = true;    
        m[y][x] = number;
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if (o(ny, nx) || v[ny][nx]) {
            dir = (dir + 1) % 4;
        }
        
        ny = y + dy[dir];
        nx = x + dx[dir];
        if (!o(ny, nx) && !v[ny][nx]) {
            dfs(dir, ny, nx, number + 1);
        }        
    }
    
    public int[][] generateMatrix(int n) {        
        m = new int[n][n];
        v = new boolean[m.length][m[0].length];
        dfs(0, 0, 0, 1);
        return m;
    }
}