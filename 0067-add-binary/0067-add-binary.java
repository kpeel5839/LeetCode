class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int round = 0;
        String answer = "";
        
        while (aIndex != -1 && bIndex != -1) {
            int aCharAt = a.charAt(aIndex) - '0';
            int bCharAt = b.charAt(bIndex) - '0';
            int now = (aCharAt + bCharAt + round) % 2;
            round = (aCharAt + bCharAt + round) / 2;
            answer = now + answer;
            aIndex--;
            bIndex--;
        }
        
        while (aIndex != -1) {
            int aCharAt = a.charAt(aIndex) - '0';
            int now = (aCharAt + round) % 2;
            round = (aCharAt + round) / 2;
            answer = now + answer;
            aIndex--;
        }
        
        if (round == 1) {
            answer = "1" + answer;
        }
        
        return answer;
    }
}