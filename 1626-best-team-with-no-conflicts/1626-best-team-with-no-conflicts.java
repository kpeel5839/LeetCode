class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] scoreAndAge = new int[scores.length][2];
        
        for (int i = 0; i < scores.length; i++) {
            scoreAndAge[i][0] = scores[i];
            scoreAndAge[i][1] = ages[i];
        }
        
        Arrays.sort(scoreAndAge, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            
            return o1[1] - o2[1];
        }); // age 로 정렬
        int[] dp = new int[scores.length];
        int answer = 0;    
        
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            
            for (int j = i - 1; j >= 0; j--) {
                if (scoreAndAge[i][0] >= scoreAndAge[j][0] || scoreAndAge[i][1] == scoreAndAge[j][1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i] = max + scoreAndAge[i][0]; // 심지어, 얘는 음수도 없어서, 무조건 더하는게 이득임, 그래서 이렇게 해도됨            
            answer = Math.max(answer, dp[i]);
        }            
        
        return answer;
    }
}