class Solution {

    public int[] nums;
    public int target;

    public int findLowerRange(int middle) {
        int l = 0;
        int r = middle;
        int findIndex = -1;
        
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                findIndex = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
            
        }

        return findIndex;
    }

    public int findUpperRange(int middle) {
        int l = middle;
        int r = nums.length - 1;
        int findIndex = -1;
        
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                findIndex = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
            
        }

        return findIndex;
    }

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] == target) {
                return new int[] {findLowerRange(m), findUpperRange(m)};
            } else {
                r = m - 1;
            }
        }
        
        return new int[] {-1, -1};
    }
}