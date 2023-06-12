class Solution {
    
    public int[] nums;
    public List<String> ans = new ArrayList<>();
    
    public void add(int left, int right) {
        if (left == right) {
            ans.add(Integer.toString(nums[right]));
            return;
        }
        
        ans.add(Integer.toString(nums[left]) + "->" + Integer.toString(nums[right]));
    }
    
    public List<String> summaryRanges(int[] nums) {
        int left = 0;
        this.nums = nums;
        
        if (nums.length == 0) {
            return ans;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                add(left, i - 1);
                left = i;
            } 
        }
        
        add(left, nums.length - 1);
        return ans; 
    }
}