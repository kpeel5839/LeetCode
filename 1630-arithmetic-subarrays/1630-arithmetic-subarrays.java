class Solution {
    
    public boolean sub(int[] nums, int l, int r) {
        if (r - l <= 1) {
            return true;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        int diff = list.get(1) - list.get(0);
        
        for (int i = 2; i < list.size(); i++) {
            if (diff != list.get(i) - list.get(i - 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        
        for (int i = 0; i < l.length; i++) {
            ans.add(sub(nums, l[i], r[i]));
        }
        
        return ans;
    }
    
}