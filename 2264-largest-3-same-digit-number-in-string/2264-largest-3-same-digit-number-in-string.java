class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        String answer = "";
        
        Loop:
        for (int i = 0; i < num.length() - 2; i++) {
            int firstDigit = num.charAt(i) - '0';
            String s = Integer.toString(firstDigit);
            
            for (int j = 1; j < 3; j++) {
                if (firstDigit != (num.charAt(i + j) - '0')) {
                    continue Loop;
                }
                
                s += num.charAt(i + j);
            }
            
            if (max == -1) {
                answer = s;
            }
            
            if (max < Integer.parseInt(s)) {
                answer = s;
                max = Integer.parseInt(s);
            }
        }
        
        return answer;
    }
}