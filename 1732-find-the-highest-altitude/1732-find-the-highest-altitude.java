class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int ans = 0;
        
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            ans = Math.max(ans, altitude);
        }
        
        return ans;
    }
}