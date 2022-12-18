class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> warmer = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!warmer.isEmpty() && temperatures[warmer.peek()] < temperatures[i]) {
                int index = warmer.pop();
                answer[index] = i - index;
            }
            
            warmer.push(i);
        }
        
        while (!warmer.isEmpty()) {
            answer[warmer.pop()] = 0;
        }
        
        return answer;
    }
}