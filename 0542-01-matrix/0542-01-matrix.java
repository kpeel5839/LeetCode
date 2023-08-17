class Solution {
    public int H;
    public int W;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }
    public int[][] updateMatrix(int[][] mat) {
        H = mat.length;
        W = mat[0].length;
        int[][] ans = new int[H][W];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < H; i++) {
            Arrays.fill(ans[i], -1);
        }
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] {i, j, 0});
                    ans[i][j] = 0;
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                
                if (outOfRange(ny, nx) || ans[ny][nx] != -1) {
                    continue;
                }
                
                q.add(new int[] {ny, nx, p[2] + 1});
                ans[ny][nx] = p[2] + 1;
            }
        }
        
        return ans;
    }
}