class Solution {
    
    public int H;
    public int W;
    public int[][] map;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }
    
    public boolean isPossible(int diff) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            if (p[0] == H - 1 && p[1] == W - 1) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                
                if (outOfRange(ny, nx) || visited[ny][nx] || diff < Math.abs(map[ny][nx] - map[p[0]][p[1]])) {
                    continue;
                }
                
                visited[ny][nx] = true;
                q.add(new int[] {ny, nx});
            }
        }
        
        return false;
    }
    
    public int minimumEffortPath(int[][] heights) {
        map = heights;
        H = heights.length;
        W = heights[0].length;
        int l = 0;
        int r = 1_000_000;
        int ans = 0;
        
        while (l <= r) {
            int m = (l + r) / 2;
            
            if (isPossible(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return ans;
    }
}