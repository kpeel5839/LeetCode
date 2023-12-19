class Solution {
    
    public int H;
    public int W;
    public int[][] img;
   
    public boolean isOutOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }
    
    public int average(int y, int x) {
        int sum = 0;
        int count = 0;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int ny = y + i;
                int nx = x + j;
                
                if (isOutOfRange(ny, nx)) {
                    continue;
                }
                
                sum += img[ny][nx];
                count++;
            }
        }
        
        return sum / count;
    }
    
    public int[][] imageSmoother(int[][] img) {
        this.img = img;
        this.H = img.length;
        this.W = img[0].length;
        
        int[][] result = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                result[i][j] = average(i, j);
            }
        }
        
        return result;
    }
}