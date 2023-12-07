class Solution {
    public String largestOddNumber(String num) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0';
            sb.append(number);
            if (number % 2 == 1) {
                answer = sb.toString();
            }
        }
        return answer;
    }
}