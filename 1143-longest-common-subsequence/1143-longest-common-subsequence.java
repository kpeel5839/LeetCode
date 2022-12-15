import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        text1 = " " + text1;
        text2 = " " + text2;
        int[][] lcsUntilNow = new int[text1.length()][text2.length()];
        
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    lcsUntilNow[i][j] = lcsUntilNow[i - 1][j - 1] + 1;
                } else {
                    lcsUntilNow[i][j] = Math.max(lcsUntilNow[i - 1][j], lcsUntilNow[i][j - 1]);
                }
            }
        }
        
        return lcsUntilNow[text1.length() - 1][text2.length() - 1];
    }
}