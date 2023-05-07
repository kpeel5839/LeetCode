class Solution {
    public int[] a;
    
    public boolean isOut(int index) {
        return !(0 <= index && index < a.length);
    }
       
    public int[] colorTheArray(int n, int[][] queries) {
        a = new int[n];
        int group = n;
        boolean[][] pair = new boolean[n][2];
        int[] ans = new int[queries.length];        
        
        for (int i = 0; i < queries.length; i++) {            
            int q1 = queries[i][0];
            int q2 = queries[i][1];            
            
            if (a[q1] != 0) {
                if (!isOut(q1 - 1)) {
                    pair[q1][0] = a[q1] == a[q1 - 1];
                }
                
                if (!isOut(q1 + 1)) {
                    pair[q1][1] = a[q1] == a[q1 + 1];
                }
            }
        
            a[q1] = q2;                    
            
            if (!isOut(q1 - 1)) {
                if (a[q1 - 1] == a[q1]) {
                    if (!pair[q1][0]) {
                        pair[q1][0] = true;
                        group--;
                    }
                } else {
                    if (pair[q1][0]) {
                        pair[q1][0] = false;
                        group++;
                    }
                }
            }
            
            if (!isOut(q1 + 1)) {
                if (a[q1 + 1] == a[q1]) {
                    if (!pair[q1][1]) {
                        pair[q1][1] = true;
                        group--;
                    }
                } else {
                    if (pair[q1][1]) {
                        pair[q1][1] = false;
                        group++;
                    }
                }
            }
            
            ans[i] = n - group;
            
            // System.out.println(Arrays.toString(a) + " " + ans[i]);
        }
        
        return ans;
    }
}