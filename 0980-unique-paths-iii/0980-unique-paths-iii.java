class Solution {
    public int height;
    public int width;
    public int desValue;
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {-1, 0, 1, 0};
    public int[] startPosition;
    public int[] destinationPosition;
    public int[][] globalGrid;
    public Map<int[], Integer> dp = new HashMap<>();
    
    public void decideDesValue() {
        desValue = (int) Math.pow(2, height * width) - 1;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {            
                if (globalGrid[i][j] == -1) {
                    desValue -= (1 << convertIndex(i, j));
                }
            }
        }
    }
    
    public boolean isOutOfRange(int y, int x) {
        return (y < 0 || y >= height) || (x < 0 || x >= width);
    }
    
    public int convertIndex(int y, int x) {
        return (y * width + x);
    }
    
    public String binary(int bit) {
        String s = "";
        while (bit != 0) {
            s = (bit % 2) + s;
            bit /= 2;
        }
        
        while (s.length() != (height * width)) {
            s = "0" + s;        
        }
               
        return s;
    }
    
    public int dfs(int bit, int y, int x) {
        if (bit != desValue && (bit & (1 << convertIndex(destinationPosition[0], destinationPosition[1]))) != 0) {
            return 0;
        }
        
        if (bit == desValue) {
            return 1;
        }
        
        int[] key = new int[] {bit, y, x};
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (isOutOfRange(ny, nx) || globalGrid[ny][nx] == -1 || (bit & (1 << convertIndex(ny, nx))) != 0) {
                continue;
            }
            
            value += dfs(bit | (1 << convertIndex(ny, nx)), ny, nx);
        }
        
        dp.put(key, value);
        return dp.get(key);
    } 
    
    public int uniquePathsIII(int[][] grid) {
        height = grid.length;
        width = grid[0].length;
        globalGrid = grid;
        decideDesValue();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    startPosition = new int[] {i, j};
                }
                
                if (grid[i][j] == 2) {
                    destinationPosition = new int[] {i, j};
                }
            }
        }
        
        return dfs(1 << convertIndex(startPosition[0], startPosition[1]), startPosition[0], startPosition[1]);
    }
}