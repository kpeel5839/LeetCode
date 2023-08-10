class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return true;
            }

            if (nums[l] == nums[m]) {
                l++;
                continue;
            }

            if (nums[l] < nums[m]) { // 일단, 더 작은 경우는 increase 하고 있는 경우 
                if (nums[l] <= target && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] <= target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;  
                }
            }
        }

        return false;
    }
}