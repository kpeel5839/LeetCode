class Solution {
    public char charAt(StringBuilder s, int i) {
        return i < 0 ? ' ' : s.charAt(i);
    }

    public String smallestBeautifulString(String s, int k) {
        int find = -1;
        StringBuilder ans = new StringBuilder(s);
        
        Loop:
        for (int i = ans.length() - 1; 0 <= i; i--) {
            int c = charAt(ans, i) - 'a';
            if (c + 1 < k) {
                for (int j = c + 2; j <= k; j++) {                
                    char cc = (char) ((j - 1) + 'a');
                    if (charAt(ans, i - 2) == cc || charAt(ans, i - 1) == cc) {
                        continue;
                    }

                    find = i;
                    ans.setCharAt(i, cc);
                    break Loop;
                }   
            }
        }

        for (int i = find + 1; i < ans.length(); i++) {
            for (int j = 0; j < k; j++) {
                char cc = (char) (j + 'a');

                if (charAt(ans, i - 2) == cc || charAt(ans, i - 1) == cc) {
                    continue;
                }

                ans.setCharAt(i, cc);
                break;
            }
        }

        return find == -1 ? "" : ans.toString();
    }
}