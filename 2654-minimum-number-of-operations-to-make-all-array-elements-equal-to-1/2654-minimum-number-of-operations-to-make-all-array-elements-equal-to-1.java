class Solution {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;    
        }
        
        return gcd(b, a % b);
    }
    
    public int minOperations(int[] nums) {    
        int n = nums.length;
        int c = 0;
        int g = 0;
            
        for (int i = 0; i < nums.length; i++) { // 모든 요소로 gcd 를 1로 만들 수 없다면, 불가능함
            g = gcd(nums[i], g);        
            if (nums[i] == 1) {
                c++;
            }
        }
        
        if (g != 1) {
            return -1;
        }
        
        if (c != 0) {
            return n - c;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int res = nums[i];
            
            for (int j = i + 1; j < n; j++) {
                res = gcd(nums[j], res);
                
                if (res == 1) {
                    min = Math.min(min, j - i);    
                }
            }
        }
        
        return n - 1 + min;
    }
}