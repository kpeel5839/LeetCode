class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        int index = 0;
        int prev = 0;

        for (int i = 1; i <= n; i++) {
            if (index == target.length) {
                break;
            }

            if (i == target[index]) {
                while (!stack.isEmpty() && stack.peek() != prev) {
                    ans.add("Pop");
                    stack.pop();
                }
                
                ans.add("Push");
                stack.push(i);
                prev = i;
                index++; 
            } else {
                ans.add("Push");
                stack.push(i);
            }
        }
        
        return ans;
    }
}