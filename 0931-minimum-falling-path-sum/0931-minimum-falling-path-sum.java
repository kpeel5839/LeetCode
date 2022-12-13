import java.util.*;

class Solution {
    public int[][] asSoonAsPossibleMinimum;
    public int N;
        
    public int getMinimumPathSum(int[][] matrix, int y, int x) {
        if (y == N - 1) {
            return matrix[y][x];
        }
        
        if (asSoonAsPossibleMinimum[y][x] != Integer.MAX_VALUE) {
            return asSoonAsPossibleMinimum[y][x];
        }
        
        asSoonAsPossibleMinimum[y][x] = 0;
        int bestChoice = Integer.MAX_VALUE;
        
        for (int i = -1; i <= 1; i++) {
            int newY = y + 1;
            int newX = x + i;
            
            if (!outOfRange(newY, newX)) {
                bestChoice = Math.min(bestChoice, getMinimumPathSum(matrix, newY, newX));
            }
        }
        
        asSoonAsPossibleMinimum[y][x] = matrix[y][x] + bestChoice;
        return asSoonAsPossibleMinimum[y][x];
    }
    
    public boolean outOfRange(int y, int x) {
        return (y < 0 || y >= N) || (x < 0 || x >= N);
    }
    
    public int minFallingPathSum(int[][] matrix) {
        N = matrix.length;
        asSoonAsPossibleMinimum = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(asSoonAsPossibleMinimum[i], Integer.MAX_VALUE);
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            answer = Math.min(answer, getMinimumPathSum(matrix, 0, i));
        }
        
        return answer;
    }
}