class Solution {

    public double[][] glass = new double[101][101];

    public double champagneTower(int poured, int row, int col) {
        glass[0][0] = poured;

        for (int i = 1; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                double left = (j == 0 || glass[i - 1][j - 1] <= 1d ? 0 : ((glass[i - 1][j - 1] - 1d) / 2d));
                double right = (glass[i - 1][j] <= 1d ? 0 : (glass[i - 1][j] - 1d) / 2d);
                glass[i][j] = left + right;
            }
        }

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(glass[i][j] + " ");
            }
            System.out.println();
        }

        return 1d <= glass[row][col] ? 1 : glass[row][col];
    }
    
}