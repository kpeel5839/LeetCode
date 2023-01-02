class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCaseCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCaseCount++;
            }
        }
        
        return upperCaseCount == word.length() || (upperCaseCount == 1 && Character.isUpperCase(word.charAt(0))) || upperCaseCount == 0;
    }
}