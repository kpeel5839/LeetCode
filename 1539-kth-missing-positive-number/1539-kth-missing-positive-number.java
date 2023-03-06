class Solution {
    public int findKthPositive(int[] arr, int k) {
        boolean[] b = new boolean[2001];
        int index = 0;
        
        for (int i = 1; i <= 2000; i++) {
            if (index != arr.length && arr[index] == i) {
                index++;
                b[i] = true;
            }
            
            if (!b[i]) {
                k--;
            }
            
            if (k == 0) {
                return i;
            }
        }
        
        return -1;
    }
}