class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0;
        int i11 = 0;
        int i2 = 0;
        int i22 = 0;

        while (i1 != word1.length && i2 != word2.length) {
            if (word1[i1].charAt(i11++) != word2[i2].charAt(i22++)) {
                return false;
            }
            
            if (word1[i1].length() == i11) {
                i1++;
                i11 = 0;
            }

            if (word2[i2].length() == i22) {
                i2++;
                i22 = 0;
            }
        }
        
        return i1 == word1.length && i2 == word2.length;
    }
}