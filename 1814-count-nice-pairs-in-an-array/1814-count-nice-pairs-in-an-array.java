class Solution {
    
    public long rev(long num) {
        StringBuilder sb = new StringBuilder(Long.toString(num));
        return Long.parseLong(sb.reverse().toString());
    }
    
    public long getDiff(long num) {
        return num - rev(num);
    }
    
    public int countNicePairs(int[] nums) {
        long[] diff = new long[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            diff[i] = getDiff(nums[i]);
        }
        
        Arrays.sort(diff);
        long count = 0;
        long answer = 0;
        long MOD = 1_000_000_007;
        
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] != diff[i - 1]) {
                answer = (answer + (((count + 1l) * count) / 2l)) % MOD;
                count = 0;
            } else {
                count++;
            }
        }
        
        answer = (answer + (((count + 1l) * count) / 2l)) % MOD;
        return (int) answer;
    }
}