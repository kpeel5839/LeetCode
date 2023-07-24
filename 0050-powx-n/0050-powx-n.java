class Solution {
    public double myPow(double x, int n) {
        long exp = n < 0 ? n * -1l : n;
        double result = 1d;
        double mul = n < 0 ? 1 / x : x;
        
        for (long i = exp; 0 < i; i >>= 1) {
            if (i % 2 == 1) {
                result *= mul;
            }
            
            mul *= mul;
        }
        
        return result;
    }
}