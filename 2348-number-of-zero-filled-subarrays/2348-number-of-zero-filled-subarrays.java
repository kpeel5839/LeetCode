class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long p = -1;
        long a = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                a += ((long) (i - p)) * ((long) (i - p - 1)) / 2;
                p = i;
            }
        }
        
        return a + (nums.length - p) * (nums.length - p - 1) / 2;
    }
}