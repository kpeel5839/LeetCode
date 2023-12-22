class Solution {
    public int maxScore(String s) {
        int[][] prefixSum = new int[2][s.length() + 1];
        
        for (int i = 1; i <= s.length(); i++) {
            char number = s.charAt(i - 1);
            prefixSum[0][i] = prefixSum[0][i - 1] + (number == '0' ? 1 : 0);
            prefixSum[1][i] = prefixSum[1][i - 1] + (number == '1' ? 1 : 0);
        }
        
        int answer = 0;
        for (int i = 1; i < s.length(); i++) {
            answer = Math.max(answer, prefixSum[0][i] + (prefixSum[1][s.length()] - prefixSum[1][i]));
        }
        return answer;
    }
}