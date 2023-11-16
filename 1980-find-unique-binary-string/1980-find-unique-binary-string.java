class Solution {
    
    public int n;
    public List<String> list = new ArrayList<>();
    
    public void dfs(String s) {
        if (n < list.size()) {
            return;
        }
        
        if (s.length() == n) {
            list.add(s);
            return;
        }
        
        dfs("0" + s);
        dfs("1" + s);
    }
    
    public String findDifferentBinaryString(String[] nums) {
        this.n = nums.length;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        dfs("");
        
        for (int i = 0; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                return list.get(i);
            }
        }
        
        return "";
    }
}