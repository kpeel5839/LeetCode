class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int[] answer = new int[2];
        
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                answer[1] = i;
            }
            
            if (count[i] == 2) {
                answer[0] = i;
            }
        }
        
        return answer;
    }
}