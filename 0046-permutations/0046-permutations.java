class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public int[] nums;
    public boolean[] visited;
    public void dfs(List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(list);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                List<Integer> copyList = new ArrayList<>(list);
                visited[i] = true;
                copyList.add(nums[i]);
                dfs(copyList);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];
        dfs(new ArrayList<>());
        return ans;
    }
}