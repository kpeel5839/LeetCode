class Solution {
    public int[] distinctDifferenceArray(int[] nums) {    
        int[] ans = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                set.add(nums[j]);
            }
            
            int a = set.size();
            set = new HashSet<>();
            
            for (int j = i + 1; j < nums.length; j++) {
                set.add(nums[j]);
            }
            
            ans[i] = a - set.size();
        }
        
        return ans;
    }
}