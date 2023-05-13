class Solution {
    public int kk = 0;
    public long cal(int[] total, int[][] n, int index) {        
        int[] temp = new int[total.length];
        
        for (int i = 0; i < total.length; i++) {
            temp[i] = total[i];
        }
        
        long v = 0;
        long vv = 0;
        for (int i = 0; i < total.length; i++) {
            if (n[i][index] == 1) {
                temp[i]--;
                v += Math.pow(2, i);                            
            }
            
            if (temp[i] != 0) {
                vv += Math.pow(2, i);
            }
        }
        
        v = (v << kk);
        
        return v | vv;
    }
    
    public long maximumOr(int[] nums, int k) {    
        int[] total = new int[30];
        int[][] n = new int[30][nums.length];
        kk = k;
        
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int index = 0;
            
            while (v != 0) {
                if (v % 2 == 1) {
                    n[index][i]++;
                    total[index]++;
                }
            
                v /= 2;
                index++;
            }
        }
            
        long ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, cal(total, n, i));
        }
        
        return ans;
    }
}