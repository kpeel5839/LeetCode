class Solution {
    public Set<List<Integer>> notDuplicate = new HashSet<>();
    public void dfs(List<Integer> visitedNodes, int[] nums, int index) {
        visitedNodes.add(nums[index]);
        if (visitedNodes.size() > 1) {
            notDuplicate.add(visitedNodes);
        }
        
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] <= nums[i]) {            
                dfs(new ArrayList<>(visitedNodes), nums, i); // deep copy
            }
        }
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {        
        for (int i = 0; i < nums.length - 1; i++) {
            dfs(new ArrayList<>(), nums, i);
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        
        for (List<Integer> subSequence : notDuplicate) {
            answer.add(subSequence);
        }
        
        return answer;
    }
}