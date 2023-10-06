class Solution {
    public int integerBreak(int n) {
        int ans = 0;

        for (int i = 1; i < n; i++) {
            int count = (n / i) - 1;
            int result = (int) Math.pow(i, count);
            int mod = n % i;

            if (mod <= 1 && count != 0) {
                result *= (i + mod);
            } else {
                result *= (i * mod);
            }

            ans = Math.max(ans, result);
        }
        
        return ans;
    }
}