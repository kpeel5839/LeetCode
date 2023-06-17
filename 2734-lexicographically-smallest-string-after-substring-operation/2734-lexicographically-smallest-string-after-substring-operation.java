class Solution {
    public String smallestString(String s) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                list.add(i);
            }
        }
        
        list.add(s.length());
        boolean operation = false;
        
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) >= 2) {
                for (int j = list.get(i) + 1; j < list.get(i + 1); j++) {
                    char c = (char) (s.charAt(j) - 1);
                    sb.setCharAt(j, c);
                }
                
                operation = true;
                break;
            }
        }
        
        if (!operation) {
            sb.setCharAt(sb.length() - 1, 'z');
        }
        
        return sb.toString();
    }
}