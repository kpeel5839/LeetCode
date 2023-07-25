class Solution {
    
    public int[] arr;
    public final int STOP = 0;
    public final int GO_RIGHT = 1;
    public final int GO_LEFT = -1;
    
    public int compare(int index) {
        boolean left = arr[index - 1] > arr[index];
        boolean right = arr[index + 1] > arr[index]; 
        
        if (!left && !right) {
            return STOP; 
        }
        
        if (left && !right) {
            return GO_LEFT;
        }
        
        return GO_RIGHT;
    }
    
    public int peakIndexInMountainArray(int[] arr) {
        this.arr = arr;
        int l = 1;
        int r = arr.length - 2;
        
        while (l <= r) {
            int m = (l + r) / 2;
            int result = compare(m);
            
            if (result == STOP) {
                return m; 
            } else if (result == GO_RIGHT) {
                l = m + 1; 
            } else {
                r = m - 1; 
            }
        }
            
        return -1;
    }
    
}