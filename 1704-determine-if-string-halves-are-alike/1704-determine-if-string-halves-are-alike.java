import java.util.*;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        int splitIndex = (s.length() / 2) - 1;
        int numberOfVowelOfFrontOfSplit = 0;
        int numberOfVowelOfBackOfSplit = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char character = Character.toLowerCase(s.charAt(i));
            
            if (!vowels.contains(character)) {
                continue;  
            }
            
            if (i <= splitIndex) {
                numberOfVowelOfFrontOfSplit++;
            } else {
                numberOfVowelOfBackOfSplit++;
            }
        }

        return numberOfVowelOfFrontOfSplit == numberOfVowelOfBackOfSplit;
    }
}