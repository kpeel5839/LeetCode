class Solution {
    public int[][] transpose(int[][] matrix) {
        int H = matrix.length;
        int W = matrix[0].length;
        int[][] result = new int[W][H];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
}