class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int H = grid.length;
        int W = grid[0].length;
        int[] row = new int[H];
        int[] col = new int[W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        int[][] diff = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                diff[i][j] = row[i] + col[j] - (W - row[i]) - (H - col[j]);
            }
        }
        
        return diff;
    }
}