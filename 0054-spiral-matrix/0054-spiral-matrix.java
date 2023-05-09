class Solution {
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    public List<Integer> ans;
    public boolean[][] v;
    public int[][] m;
    
    public boolean o(int y, int x) {
        return y < 0 || y >= m.length || x < 0 || x >= m[0].length;
    }
    
    public void dfs(int dir, int y, int x) {
        v[y][x] = true;
        ans.add(m[y][x]);
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        
        if (o(ny, nx) || v[ny][nx]) {
            dir = (dir + 1) % 4;
        }
        
        ny = y + dy[dir];
        nx = x + dx[dir];
        if (!o(ny, nx) && !v[ny][nx]) {
            dfs(dir, ny, nx);
        }        
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        ans = new ArrayList<>();
        m = matrix;
        v = new boolean[m.length][m[0].length];
        dfs(0, 0, 0);
        return ans;
    }
}