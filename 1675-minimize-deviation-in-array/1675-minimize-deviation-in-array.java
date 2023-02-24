class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                nums[i] *= 2;
            }
            
            min = Math.min(min, nums[i]);
            queue.add(nums[i]);
        }
    
        int answer = Integer.MAX_VALUE;
        System.out.println(queue);
        
        while (!queue.isEmpty() && queue.peek() % 2 == 0) {
            int number = queue.poll() / 2;
            min = Math.min(min, number);
            queue.add(number);
            answer = Math.min(answer, queue.peek() - min);
        }
        
        return answer;
    }
}