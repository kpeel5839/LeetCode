class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int value = 1;
        
        for (int i = 1; i <= arr.length; i++) {
            if (value <= arr[i - 1]) {
                value++;
            }
        }
        
        return value - 1;
    }
}