class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            int index = m.get(nums[i]) - 1;
            
            if (answer.size() <= index) {
                answer.add(new ArrayList<>());
            }
            
            answer.get(index).add(nums[i]);
        }
        
        return answer;
    }
}