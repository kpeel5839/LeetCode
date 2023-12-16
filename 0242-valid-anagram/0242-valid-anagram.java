class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            a1[s.charAt(i) - 'a']++;
            a2[t.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        
        return true;
    }
}