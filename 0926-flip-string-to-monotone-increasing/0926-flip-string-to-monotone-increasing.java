class Solution {
    
    public int minFlipsMonoIncr(String s) {
        int ones = 0;
        int answer = 0;
        
        for (int i= 0; i < s.length(); i++) {
            int now = s.charAt(i) - '0';
            
            if (now == 1) {
                ones++;
            }
            
            if (now == 0 && ones != 0) {
                ones--;
                answer++;
            }
        }
        
        return answer;
    }
}