class Solution {
    
    public int exp(int a, int b, int mod) {
        int res = 1;
        int mul = a;
        
        for (int i = 0; i < 10; i++) {
            if ((b & (1 << i)) != 0) {
                res = (res * mul) % mod;
            }
            
            mul = (mul * mul) % mod;
        }
        
        return res;
    }
    
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int result = exp(variables[i][0], variables[i][1], 10);
            result = exp(result, variables[i][2], variables[i][3]);
            if (result == target) {
                ans.add(i);
            }
        }
        return ans;
    }
}