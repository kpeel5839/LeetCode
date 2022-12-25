class Solution {
    public int lowerBound(int[] sectionSum, int findValue) {
        int left = 0;
        int right = sectionSum.length - 1;
        int findIndex = 0;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            
            if (sectionSum[middle] <= findValue) {
                findIndex = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return findIndex;
    }
    
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sectionSum = new int[nums.length + 1];
        int[] answer = new int[queries.length];
        
        for (int i = 1; i <= nums.length; i++) {
            sectionSum[i] = sectionSum[i - 1] + nums[i - 1];
        }
        
        for (int i = 0; i < queries.length; i++) {
            answer[i] = lowerBound(sectionSum, queries[i]);
        }
        
        return answer;
    }
}