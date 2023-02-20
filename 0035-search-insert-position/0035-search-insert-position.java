class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);    
        }
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;        
            
            if (list.get(mid) < target) {
                answer = mid;
                left = mid + 1;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {            
                return mid - 1;
            }
        }
        
        return answer;
    }
}