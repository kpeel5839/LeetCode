class Solution {
    public int numberOfBeams(String[] bank) {
        int answer = 0;
        int preIndex = 0;
        
        for (int i = 1; i < bank.length; i++) {
            int preOneCount = 0;
            int nowOneCount = 0;
            
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[preIndex].charAt(j) == '1') {
                    preOneCount++;
                }
                
                if (bank[i].charAt(j) == '1') {
                    nowOneCount++;
                }
            }
            
            if (nowOneCount == 0) {
                continue;
            }
            
            answer += nowOneCount * preOneCount;
            preIndex = i;
        }
        
        return answer;
    }
}