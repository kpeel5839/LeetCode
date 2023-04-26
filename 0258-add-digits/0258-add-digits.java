class Solution {
    public String c(String s) {
        int n = 0;
        
        for (int i = 0; i < s.length(); i++) {
            n += (s.charAt(i) - '0');
        } 
        
        return Integer.toString(n);
    }
    
    public int addDigits(int num) {
        String s= Integer.toString(num);
        
        while (1 < s.length()) {
            s = c(s);    
        }   
        
        return Integer.parseInt(s);
    }
}