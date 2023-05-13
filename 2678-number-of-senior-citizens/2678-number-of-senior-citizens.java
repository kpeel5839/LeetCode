class Solution {
    public int countSeniors(String[] details) {
        int n = 0;
        for (int i = 0; i < details.length; i++) {
            if (60 < Integer.parseInt(details[i].substring(11, 13))) {
                n++;   
            }
        }
        return n;
    }
}