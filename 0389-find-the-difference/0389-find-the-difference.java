class Solution {

    public int[] count = new int[26];

    public char findTheDifference(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                return (char) (i + 'a');
            }
        }
        
        return 'a';
    }

}