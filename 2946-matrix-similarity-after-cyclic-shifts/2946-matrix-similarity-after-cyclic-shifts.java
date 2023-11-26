class Solution {
    
    public int H;
    public int W;
    public int[][] mat;
    public int k;
    
    public boolean solution() {
        int[][] pre = doCopy(mat);
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i % 2 != 0) {
                    pre[i][(j + k) % W] = mat[i][j];
                } else {
                    pre[i][(j - k + (50 * W)) % W] = mat[i][j];
                }
            }
        }

        return equals(pre);
    }
    
    public int[][] doCopy(int[][] copy) {
        int[][] result = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                result[i][j] = copy[i][j];
            }
        }
        
        return result;
    }
    
    public boolean equals(int[][] copy) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (mat[i][j] != copy[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
    
    public boolean areSimilar(int[][] mat, int k) {
        this.H = mat.length;
        this.W = mat[0].length;
        this.mat = mat;
        this.k = k;
        return solution();
    }
    
}