class Solution {
    public void parsing(boolean[] isPossible, String s) {
        for (int i = 1; i <= s.length(); i++) {
            Set<String> duplicateChecker = new HashSet<>();
            int index = 0;
        
            while (s.length() % i == 0) {
                duplicateChecker.add(s.substring(index, index + i));
                index += i;
                
                if (duplicateChecker.size() >= 2 || s.length() <= index) {
                    break;
                }
            }
            
            if (duplicateChecker.size() == 1) {
                isPossible[i] = true;
            }
        }
    }
        
    public String gcdOfStrings(String str1, String str2) {
        boolean[] isPossibleOfStr1 = new boolean[str1.length() + 1];
        boolean[] isPossibleOfStr2 = new boolean[str2.length() + 1];
        parsing(isPossibleOfStr1, str1);
        parsing(isPossibleOfStr2, str2);
        
        for (int i = Math.min(str1.length(), str2.length()); i != 0; i--) {
            if (isPossibleOfStr1[i] && isPossibleOfStr2[i] && str1.substring(0, i).equals(str2.substring(0, i))) {
                return str1.substring(0, i);
            }
        }
        
        return "";
    }
}