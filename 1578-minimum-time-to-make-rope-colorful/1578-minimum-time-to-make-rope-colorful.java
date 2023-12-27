class Solution {
    
    public int minCost(String colors, int[] neededTime) {
        int answer = 0; 
        char pre = colors.charAt(0);
        int max = 0;
        int sum = 0;
        
        for (int i = 0; i < colors.length(); i++) { 
            char c = colors.charAt(i);
            
            if (pre != c) { 
                answer += (sum - max);
                sum = 0;
                max = 0;
                pre = c;
            } 
            
            sum += neededTime[i];
            max = Math.max(max, neededTime[i]);
        }
       
        answer += (sum - max);
        return answer;
    }
}