class Solution {

    public Set<Character> set = new HashSet<>();
    public int H;
    public int W;
    public char[][] grid;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    public int[][][] visited;
    public int[] start = new int[2];
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }
    
    public int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1], 0, 1}); // {y, x, bit, distance};
        visited[0][start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[2] == (1 << set.size()) - 1) {
                return point[3] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];
                int bit = point[2];

                if (outOfRange(ny, nx)) {
                    continue; 
                }
                
                if (Character.isAlphabetic(grid[ny][nx])) {
                    int c = Character.toLowerCase(grid[ny][nx]) - 'a';
                    if (Character.isUpperCase(grid[ny][nx]) && (bit & (1 << c)) == 0) {
                        continue; 
                    } else {
                        bit |= 1 << c;
                    }
                }

                if (grid[ny][nx] == '#' || visited[bit][ny][nx] != 0) {
                    continue;
                }

                q.add(new int[] {ny, nx, bit, point[3] + 1});
                visited[bit][ny][nx] = point[3] + 1;
            }
        } 

        return -1;
    }
    
    public int shortestPathAllKeys(String[] grid) {
        H = grid.length;
        W = grid[0].length();
        this.grid = new char[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                this.grid[i][j] = grid[i].charAt(j);

                if (this.grid[i][j] == '@') {
                    start[0] = i;
                    start[1] = j; 
                    this.grid[i][j] = '.';
                }

                if (Character.isAlphabetic(this.grid[i][j])) {
                    set.add(Character.toLowerCase(this.grid[i][j]));
                }
            }
        } 

        visited = new int[1 << set.size()][H][W];
        return bfs();
    }
}