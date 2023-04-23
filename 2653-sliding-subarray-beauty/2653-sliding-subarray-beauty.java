class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {    
        int n = nums.length;
        int[] c = new int[102];    
        int[] ans = new int[n - k + 1];
        int l = 0;
        
        for (int i = 0; i < n; i++) {
            c[nums[i] + 50]++;        
            
            if (i - l + 1 == k) {                
                int xx = 0;
                
                for (int j = 0; j < 50; j++) {
                    xx += c[j];
                    
                    if (x <= xx) {
                        ans[l] = j - 50;
                        break;
                    }
                }
                        
                c[nums[l] + 50]--;
                l++;
            }
        }
        
        return ans;
    }
}