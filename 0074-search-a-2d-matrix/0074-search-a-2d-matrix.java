class Solution {
    public int[][] matrix;
    public int target;
    public int H;
    public int W;
    public int STOP = 0;
    public int GO_LEFT = 1;
    public int GO_RIGHT = 2;
    public int judgeRow(int row) {
        if (matrix[row][0] <= target && target <= matrix[row][W - 1]) {
            return STOP;      
        }

        if (matrix[row][W - 1] < target) {
            return GO_RIGHT;
        }

        return GO_LEFT; 
    } 
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        this.H = matrix.length;
        this.W = matrix[0].length;
        int l = 0;
        int r = H - 1;
        int row = -1;   
        
        while (l <= r) {
            int m = (l + r) / 2;
            int direction = judgeRow(m);

            if (direction == STOP) {
                row = m;
                break;
            } else if (direction == GO_RIGHT) {
                l = m + 1;
            } else {
                r = m - 1; 
            }
        }

        if (row == -1) {
            return false;
        }

        l = 0;
        r = W - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            
            if (matrix[row][m] < target) {
                l = m + 1;
            } else if (matrix[row][m] == target) {
                return true;
            } else {
                r = m - 1;
            }
        }
        
        return false;
    }
}