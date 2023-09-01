class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int value = i; 
            int count = 0;

            while (value != 0) {
                if ((value % 2) == 1) {
                    count++; 
                }
                
                value /= 2;
            }
            
            ans[i] = count;
        }

        return ans;
    }
}