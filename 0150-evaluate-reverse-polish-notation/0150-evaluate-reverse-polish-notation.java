class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();    
        
        for (int i = 0; i < tokens.length; i++) {        
            try {
                int number = Integer.parseInt(tokens[i]);
                stack.push(number);
            } catch (NumberFormatException e) {
                char operator = tokens[i].charAt(0);
                int second = stack.pop();
                int first = stack.pop();            
                
                if (operator == '+') {
                    first += second;
                }
                
                if (operator == '-') {
                    first -= second;
                }
                
                if (operator == '*') {
                    first *= second;
                }
                
                if (operator == '/') {
                    first /= second;
                }
                
                stack.push(first);
            }
        }
        
        return stack.pop();
    }
}