class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] sum = new int[n];
        sum[0] = customers.charAt(0) == 'Y' ? 1 : 0;
        
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }
        
        int min = Integer.MAX_VALUE;
        int index = 0;
        
        for (int i = 0; i <= n; i++) {
            int value = (i == 0 ? 0 : i - sum[i - 1]) + (i == 0 ? sum[n - 1] : sum[n - 1] - sum[i - 1]);
            if (value < min) {
                min = value;
                index = i;
            }
        }
        
        return index;
    }
}