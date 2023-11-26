class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int H = matrix.length;
        int W = matrix[0].length;
        int[][] count = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (matrix[i][j] == 1) {
                    count[i][j] = (i == 0 ? 0 : count[i - 1][j]) + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            Arrays.sort(count[i]);
            int min = Integer.MAX_VALUE;
            
            for (int j = W - 1; 0 <= j; j--) {
                min = Math.min(min, count[i][j]);
                answer = Math.max(answer, (W - j) * min);
            }
        }

        return answer;
    }
}