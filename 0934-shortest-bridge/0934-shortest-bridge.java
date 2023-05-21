class Solution {
    public int n;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    
    public class Point {
        int y;
        int x;
        int value;
        
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
        
        Point(int y, int x, int value) {
            this(y, x);
            this.value = value;
        }
        
        public String toString() {
            return "(" + y + ", " + x + ")";
        }
    }
    
    public Queue<Point> edge = new LinkedList<>();
    public int[][] island;
    public int[][] g;
    
    public boolean outOfRange(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= n;
    }
    
    public void islandNumber(int y, int x, int in) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        
        while (!q.isEmpty()) {
            Point point = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                
                if (outOfRange(ny, nx) || g[ny][nx] == 0 || island[ny][nx] != 0) {
                    continue;
                }
                
                q.add(new Point(ny, nx));
                island[ny][nx] = in;                
            }
        }
    }
    
    public void findEdge(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        boolean[][] visited = new boolean[n][n];
        visited[y][x] = true;
        
        while (!q.isEmpty()) {
            Point point = q.poll();
            boolean ez = false;
            
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                
                if (outOfRange(ny, nx) || visited[ny][nx]) {
                    continue;
                }
                
                if (g[ny][nx] != g[y][x]) {
                    ez = true;
                    continue;
                }
                
                q.add(new Point(ny, nx));
                visited[ny][nx] = true;
            }
            
            if (ez) {
                edge.add(new Point(point.y, point.x, 0));
            }
        }
    }
    
    public int findShortestPath() {
        boolean[][] visited = new boolean[n][n];        
        
        while (!edge.isEmpty()) {
            Point point = edge.poll();
            
            if (visited[point.y][point.x]) {
                continue;
            }
            
            visited[point.y][point.x] = true;
            
            for (int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];
                
                if (outOfRange(ny, nx) || visited[ny][nx] || island[ny][nx] == 1) {
                    continue;
                }
                
                if (island[ny][nx] == 2) {
                    return point.value;
                }
                                
                edge.add(new Point(ny, nx, point.value + 1));        
            }
        }
        
        return -1;
    }
        
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        island = new int[n][n];
        g = grid;
        int islandCount = 1;
        int y = -1;
        int x = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && island[i][j] == 0) {
                    if (y == -1 && x == -1) {
                        y = i;
                        x = j;   
                    }
                    
                    island[i][j] = islandCount;
                    islandNumber(i, j, islandCount++);
                }
            }
        }
        
        findEdge(y, x);
        return findShortestPath();
    }
}