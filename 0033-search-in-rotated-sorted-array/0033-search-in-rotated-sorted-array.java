class Solution {
    public int target;
    public int[] nums;
    public int n;
    public int search(int l, int r) {
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1; 
            } else {
                return m;
            }
        }

        return -1;
    }
    public int search(int[] nums, int target) {
        this.n = nums.length;
        this.target = target;
        this.nums = nums;
        int last = nums[n - 1];
        int l = 0;
        int r = n - 1;
        int bound = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            
            if (nums[m] <= last) {
                bound = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        int result1 = search(0, bound - 1);
        int result2 = search(bound, n - 1); 
        
        if (result1 != -1) {
            return result1;
        }

        return result2;
    }
}