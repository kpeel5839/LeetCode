class Solution {
    public void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = (l + r) / 2;
            mergeSort(nums, l, p);
            mergeSort(nums, p + 1, r);
            merge(nums, l, r, p);
        }
    }
    
    public void merge(int[] nums, int l, int r, int p) {
        int lIndex = l;
        int rIndex = p + 1;
        int[] tmp = new int[r - l + 1];
        int tIndex = 0;
        
        while (lIndex <= p && rIndex <= r) {
            if (nums[lIndex] <= nums[rIndex]) {
                tmp[tIndex++] = nums[lIndex++];
            } else {
                tmp[tIndex++] = nums[rIndex++];
            }
        }
        
        while (lIndex <= p) {
            tmp[tIndex++] = nums[lIndex++];
        }
        
        while (rIndex <= r) {
            tmp[tIndex++] = nums[rIndex++];
        }
        
        tIndex = 0;
        
        for (int i = l; i <= r; i++) {
            nums[i] = tmp[tIndex++];
        }
    }
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}