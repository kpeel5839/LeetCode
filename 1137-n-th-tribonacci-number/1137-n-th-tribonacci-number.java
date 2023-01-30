class Solution {
    public int tribonacci(int n) {
        int[] init = new int[] {0, 1, 1};
        int[] fibonacci = new int[n + 1];
        
        if (n < 3) {
            return init[n];
        } else {
            for (int i = 0; i < 3; i++) {
                fibonacci[i] = init[i];
            }
            
            for (int i = 3; i <= n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] + fibonacci[i - 3];
            }
            
            return fibonacci[n];
        }
    }
}