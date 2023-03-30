class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int sum = 0;
        int[] s = new int[satisfaction.length];
        Arrays.sort(satisfaction); 
        
        for (int i = satisfaction.length - 1; i != -1; i--) {
            sum += satisfaction[i];
            s[i] = sum;
        } 
        
        int ans = 0;
        int time = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            if (0 <= s[i]) {
                time++;
                ans += time * satisfaction[i];   
            }        
        }
        
        return ans;
    }
}