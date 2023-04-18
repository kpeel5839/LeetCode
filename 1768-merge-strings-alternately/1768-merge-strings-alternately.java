class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l = 0;
        int r = 0;
        StringBuilder ans = new StringBuilder();
        
        while (l < word1.length() || r < word2.length()) {
            if (l < word1.length()) {
                ans.append(word1.charAt(l++));
            }
            
            if (r < word2.length()) {
                ans.append(word2.charAt(r++));
            }
        }
        
        return ans.toString();
    }
}