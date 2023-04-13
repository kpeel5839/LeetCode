class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < pushed.length; i++) {
            m.put(pushed[i], i);
        }
        
        int index = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < popped.length; i++) {
            int ii = m.get(popped[i]);
            
            while (index < ii) {
                index++;
                stack.push(pushed[index]);            
            }
            
            if (stack.isEmpty()) {
                return false;
            } else {
                if (stack.pop() != popped[i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}