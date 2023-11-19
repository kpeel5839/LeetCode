class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        List<Integer> compression = new ArrayList<>();
        int pre = nums[0];
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (pre != nums[i]) {
                compression.add(count);
                pre = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        
        compression.add(count);
        int answer = 0;
        
        for (int i = compression.size() - 2; 0 <= i; i--) {
            answer += compression.get(i + 1);
            compression.set(i, compression.get(i) + compression.get(i + 1));
        }
        
        return answer;
    }
}