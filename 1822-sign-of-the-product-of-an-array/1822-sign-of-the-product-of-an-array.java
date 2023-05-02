class Solution {
    public int convert(int n) {
        return n > 0 ? 1 : n < 0 ? -1 : 0;
    }
    
    public int arraySign(int[] nums) {
        int n = convert(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            n = convert(n * nums[i]);
        }
        
        return n;
    }
}