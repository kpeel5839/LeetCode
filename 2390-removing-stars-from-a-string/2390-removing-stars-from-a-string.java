class Solution {
    public String removeStars(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(i);   
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(s.charAt(stack.pop()));
        }
        
        sb.reverse();
        return sb.toString();
    }
}