class Solution {
    public String largestOddNumber(String num) {
        int lastIndex = -1;
        
        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0';
            if (number % 2 == 1) {
                lastIndex = i;
            }
        }
        
        if (lastIndex == -1) {
            return "";
        }
        
        return num.substring(0, lastIndex + 1);
    }
}