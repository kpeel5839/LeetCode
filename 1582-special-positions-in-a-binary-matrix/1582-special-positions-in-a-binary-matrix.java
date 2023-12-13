class Solution {
    public int numSpecial(int[][] mat) {
        int H = mat.length;
        int W = mat[0].length;
        int[] row = new int[H];
        int[] col = new int[W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}