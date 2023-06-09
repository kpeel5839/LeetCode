class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char first = letters[0];
        Arrays.sort(letters);
        
        for (int i = 0; i < letters.length; i++) {
            if (target < letters[i]) {
                return letters[i];
            }
        }
        
        return first;
    }
}