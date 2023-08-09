class Solution {
    public int n;
    public int[] nums;
    public int p;
    public boolean isPossible(int m) {
        int count = 0;
        boolean select = false;

        for (int i = 0; i < n - 1; i++) {
            if (select) {
                select = false;
            } else {
                if (Math.abs(nums[i] - nums[i + 1]) <= m) {
                    select = true;
                    count++;
                }
            }
        }

        return p <= count;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        this.n = nums.length;
        this.nums = nums;
        this.p = p;

        int l = 0;
        int r = (int) Math.pow(10, 9);
        int ans = 0;

        while (l <= r) {
            int m = (l + r) / 2;

            if (isPossible(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1; 
            }
        }

        return ans;
    }
}