class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustMe = new int[n + 1];
        int[] trustYou = new int[n + 1];
        
        for (int i = 0; i < trust.length; i++) {
            trustMe[trust[i][1]]++; // 본인을 믿는 사람의 수
            trustYou[trust[i][0]]++; // 본인이 믿는 사람의 수
        }
        
        int label = -1;
        
        for (int i = 1; i <= n; i++) {
            if (trustMe[i] == (n - 1) && trustYou[i] == 0) {
                if (label != -1) {
                    return -1;
                }
                
                label = i;
            }
        }
        
        return label;
    }
}