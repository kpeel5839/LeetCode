class Solution {
    public int strStr(String haystack, String needle) {
        int index = 0;
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            while (index != needle.length() && haystack.charAt(i + index) == needle.charAt(index)) {
                index++;
            }
            
            if (index == needle.length()) {
                return i;        
            }
            
            index = 0;
        }
        
        return -1;
    }
}