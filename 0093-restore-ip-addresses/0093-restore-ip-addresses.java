class Solution {
    public List<String> answer = new ArrayList<>();
    
    public void addAnswerWhenValidForm(String s, int[] dotPoint) {
        String[] splitString = new String[4];
        for (int i = 0; i <= 3; i++) {
            splitString[i] = s.substring(dotPoint[i], dotPoint[i + 1]);
            
            if (!(isRightDigit(splitString[i]) && isCorrectNumber(splitString[i]) && isRightRange(splitString[i]))) {
                return;
            }
        }
        
        StringBuilder ipAddress = new StringBuilder();
        for (int i = 0; i <= 3; i++) {
            ipAddress.append(splitString[i]).append(".");
        }
        
        ipAddress.deleteCharAt(ipAddress.length() - 1);
        answer.add(ipAddress.toString());
    }
    
    public boolean isRightDigit(String s) { // true 이면 맞음
        return 0 < s.length() && s.length() <= 3;
    }
    
    public boolean isCorrectNumber(String s) { // true 이면 맞음
        return !(s.length() != 1 && s.charAt(0) == '0');
    }
    
    public boolean isRightRange(String s) {
        return 0 <= Integer.parseInt(s) && Integer.parseInt(s) <= 255;
    }
    
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        
        for (int i = 1; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                for (int c = j + 1; c < s.length(); c++) {
                    addAnswerWhenValidForm(s, new int[] {0, i, j, c, s.length()});
                }
            }
        }
        
        return answer;
    }
}