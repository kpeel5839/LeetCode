class Solution {    
    int index = 0;
    
    public void cal(char[] chars, char pre, int cnt) {
        chars[index++] = pre;
        
        if (cnt != 1) {
            String c = Integer.toString(cnt);
            
            for (int i = 0; i < c.length(); i++) {
                chars[index++] = c.charAt(i);
            }
        }
    }
    
    public int compress(char[] chars) {
        char pre = chars[0];
        int cnt = 1;
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != pre) {            
                cal(chars, pre, cnt);
                pre = chars[i];
                cnt = 0;
            }
        
            cnt++;
        }
        
        cal(chars, pre, cnt);
        
        return index;
    }
}