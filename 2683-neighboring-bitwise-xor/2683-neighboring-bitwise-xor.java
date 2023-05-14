class Solution {
    public boolean dd(int start, int[] d) {
        int n = d.length;
        int[] arr = new int[n];
        arr[0] = start;
        
        for (int i = 0; i < n; i++) {        
            if (d[i] == 0) { // same
                arr[(i + 1) % n] = arr[i];
            } else { // different
                arr[(i + 1) % n] = (arr[i] + 1) % 2;
            }
            
        }
        
        return arr[0] == start;
    }
    
    public boolean doesValidArrayExist(int[] derived) {
        return dd(0, derived) || dd(1, derived);
    }
}