class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int impossible = Integer.MIN_VALUE;
        
        for (int i = 0; i < piles.size(); i++) {
            int sum = piles.get(i).get(0);
            for (int j = 1; j < piles.get(i).size(); j++) {
                sum += piles.get(i).get(j);
                piles.get(i).set(j, sum);
            }
        } // 누적합으로 변경
    
        int[][] dp = new int[k + 1][piles.size()];
        
        for (int i = 0; i < k; i++) {
            if (k - i <= piles.get(piles.size() - 1).size()) {
                dp[i][piles.size() - 1] = piles.get(piles.size() - 1).get(k - i - 1);
            } else {
                dp[i][piles.size() - 1] = impossible;
            }
        }
        
        for (int i = piles.size() - 2; 0 <= i; i--) {
            for (int j = 0; j < k; j++) {
                int max = dp[j][i + 1]; // 아무것도 선택하지 않는 경우 현재에서
                
                for (int c = 0; c <= Math.min(piles.get(i).size() - 1, k - j - 1) ; c++) { // 선택하는 경우                
                    max = Math.max(max, dp[j + c + 1][i + 1] + piles.get(i).get(c));
                }
                
                dp[j][i] = max; // 최종적으로 가장 큰 요소를 선택
            }
        }
        
        return dp[0][0];
    }
}