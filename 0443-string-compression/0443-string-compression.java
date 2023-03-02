class Solution {    
    List<Character> list = new ArrayList<>();
    
    public void cal(char pre, int cnt) {
        list.add(pre);
        
        if (cnt != 1) {
            String c = Integer.toString(cnt);
            
            for (int i = 0; i < c.length(); i++) {
                list.add(c.charAt(i));
            }
        }
    }
    
    public int compress(char[] chars) {
        char pre = chars[0];
        int cnt = 1;
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != pre) {            
                cal(pre, cnt);
                pre = chars[i];
                cnt = 0;
            }
        
            cnt++;
        }
        
        cal(pre, cnt);
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        
        return list.size();
    }
}