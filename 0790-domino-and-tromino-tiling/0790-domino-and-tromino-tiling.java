class Solution {
    public int tileLength;
    public long[][] numberOfMethod;
    public final int MOD = (int) Math.pow(10, 9) + 7;
    
    public long getNumberOfMethod(int column, int state) {
        if (tileLength <= column) {
            if (state != 0 || tileLength < column) {
                return 0;
            }
            
            if (state == 0) {
                return 1;
            }    
        }
        
        if (numberOfMethod[state][column] != -1) {
            return numberOfMethod[state][column];
        }
        
        numberOfMethod[state][column] = 0;
        
        if (state == 0) {        
            numberOfMethod[state][column] += getNumberOfMethod(column + 2, 0);
            numberOfMethod[state][column] += getNumberOfMethod(column + 1, 0);
            numberOfMethod[state][column] += getNumberOfMethod(column + 1, 1);
            numberOfMethod[state][column] += getNumberOfMethod(column + 1, 2);
        }
        
        if (state == 1) {        
            numberOfMethod[state][column] += getNumberOfMethod(column + 2, 0);
            numberOfMethod[state][column] += getNumberOfMethod(column + 1, 2);
        }
        
        if (state == 2) {
            numberOfMethod[state][column] += getNumberOfMethod(column + 2, 0);
            numberOfMethod[state][column] += getNumberOfMethod(column + 1, 1);
        }
        
        numberOfMethod[state][column] %= MOD;
        return numberOfMethod[state][column];
    }
    
    public int numTilings(int n) {
        tileLength = n;
        numberOfMethod = new long[3][n];
        
        for (int i = 0; i < 3; i++) {
            Arrays.fill(numberOfMethod[i], -1);
        }
        
        return (int) getNumberOfMethod(0, 0);
    }
}