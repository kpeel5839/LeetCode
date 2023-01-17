class Solution {
    public int oppose(int num) {
        if (num == 0) {
            return 1;
        }
        
        return 0;
    }
    
    public int isFlip(int pivot, int compare) {
        if (pivot == compare) {
            return 0;
        }
        
        return 1;
    }
    
    public int minFlipsMonoIncr(String s) {
        int[][] flipCount = new int[2][s.length()];
        int allRemoveCount = 0;
        
        int lastChar = s.charAt(s.length() - 1) - '0';
        if (lastChar == 1) {
            allRemoveCount++;
        }
        
        flipCount[oppose(lastChar)][s.length() - 1] = 1;
        flipCount[lastChar][s.length() - 1] = 0;
        
        for (int i = s.length() - 2; i > -1; i--) {
            int now = s.charAt(i) - '0';
            
            if (now == 1) {
                allRemoveCount++;
            }
            
            if (i == s.length() - 2) {
                flipCount[oppose(now)][i] += flipCount[1][i + 1] + 1;
                flipCount[now][i] += flipCount[1][i + 1];
            }
        
            if (i != s.length() - 2) {
                flipCount[0][i] += Math.min(flipCount[0][i + 1], flipCount[1][i + 1]) + isFlip(now, 0);
                flipCount[1][i] += flipCount[1][i + 1] + isFlip(now, 1);   
            }     
        }
        
        int result = Math.min(allRemoveCount, Math.min(flipCount[0][0], flipCount[1][0]));
        return result;
    }
}