class Solution {
    public int getWinner(int[] arr, int k) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {arr[0], 1});
        
        for (int i = 1; i < arr.length; i++) {
            if (!stack.isEmpty() && arr[i] < stack.peek()[0]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
                int[] p = stack.pop();
                
                if (k <= i - p[1]) { 
                    return p[0];
                }
            }
            
            stack.push(new int[] {arr[i], i});
        }

        return stack.pop()[0];
    }
}