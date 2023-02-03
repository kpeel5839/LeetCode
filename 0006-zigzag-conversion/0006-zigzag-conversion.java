class Solution {
    StringBuilder answer = new StringBuilder();
    public void calZigZag(int startRow, String s, int numRows) {
        int period = (numRows - 1) * 2;
        int eachPeriod = (numRows - startRow) * 2;
        int index = startRow;
        answer.append(s.charAt(index - 1));
        
        while (true) {
            if (!(startRow == 1 || startRow == numRows)) { // 얘내들은 그냥 다음 period 만 따짐
                if (index + eachPeriod <= s.length()) {
                    answer.append(s.charAt(index + eachPeriod - 1));
                }
            }
            
            index += period;
            
            if (s.length() < index) {
                break;
            }
            
            answer.append(s.charAt(index - 1));
        }
    }
    
    public String convert(String s, int numRows) {
        if (numRows != 1) {
            for (int i = 1; i <= Math.min(s.length(), numRows); i++) {
                calZigZag(i, s, numRows);
            }   
        } else {
            answer.append(s);
        }
        
        return answer.toString();
    }
}