class Solution {
    public String convertToTitle(int c) {
        String s = "";
        while (c != 0) {
            char now;
            if (c % 26 == 0) {
                now = 'Z';
                c--;
            } else {
                now = (char) (c % 26 + 'A' - 1);
            }
            s = now + s;
            c /= 26;
        }
        return s;
    }
}