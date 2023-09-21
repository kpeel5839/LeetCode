class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
        if (n1.length > n2.length) {
            int[] t = n1;
            n1 = n2;
            n2 = t;
        }
        
        int size = n1.length + n2.length;
        int half = (size + 1) / 2;
        int l = 0;
        int r = n1.length;
        while (l <= r) {        
            int m = (l + r) / 2;
            int j = half - m;            
            int n1l = m != 0 ? n1[m - 1] : -987654321;
            int n1r = m != n1.length ? n1[m] : 987654321;
            int n2l = j != 0 ? n2[j - 1] : -987654321;
            int n2r = j != n2.length ? n2[j] : 987654321;        
            
            if (n1l <= n2r && n2l <= n1r) {
                if (size % 2 == 0) {
                    return (Math.max(n1l, n2l) + Math.min(n1r, n2r)) / 2d;
                } else {
                    return Math.max(n1l, n2l);
                }
            }
            
            if (n2r < n1l) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return 0.0;
    }
}