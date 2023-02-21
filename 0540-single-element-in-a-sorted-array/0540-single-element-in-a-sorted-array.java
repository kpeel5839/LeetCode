class Solution {
    public int getPosition(int[] nums, int index) {
        int value = nums[index];
        int resultIndex = index;
        if (index != 0 && value == nums[index - 1]) {
            resultIndex = index - 1;
        }
        
        return resultIndex;
    }
    
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = 0;
    
        while (left <= right) {
            int mid = (left + right) / 2;        
            mid = getPosition(nums, mid);                
            
            if (mid % 2 == 0) {
                answer = mid;
                left = mid + 2;
            } else {
                right = mid - 1;
            }
        }
        
        return nums[answer];
    }
}