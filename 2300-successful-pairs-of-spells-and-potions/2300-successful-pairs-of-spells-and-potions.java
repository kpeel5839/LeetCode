class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int SIZE = 100000;
        int[] v = new int[SIZE + 1];
        
        for (int i = 0; i < potions.length; i++) {
            v[potions[i]]++;
        }
        
        for (int i = v.length - 2; i != -1; i--) {
            v[i] += v[i + 1];
        }        
        
        int[] ans = new int[spells.length];
        
        for (int i = 0; i < ans.length; i++) {
            long pivot = (long) Math.ceil((double) success / (double) spells[i]);
            
            if (SIZE < pivot) {
                ans[i] = 0;
            } else {
                ans[i] = v[(int) pivot];
            }
        }
        
        return ans;
    }
}