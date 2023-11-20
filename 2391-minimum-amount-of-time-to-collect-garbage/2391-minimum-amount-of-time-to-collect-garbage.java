class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] sum = new int[garbage.length];
        int mCount = 0;
        int mLastIndex = 0;
        int pCount = 0;
        int pLastIndex = 0;
        int gCount = 0;
        int gLastIndex = 0;
        
        for (int i = 1; i < sum.length; i++) {
            sum[i] = travel[i - 1] + sum[i - 1];
        }
        
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                char c = garbage[i].charAt(j);
                
                if (c == 'G') {
                    gCount++;
                    gLastIndex = i;
                } else if (c == 'P') {
                    pCount++;
                    pLastIndex = i;
                } else {
                    mCount++;
                    mLastIndex = i;
                }
            }
        }
        
        return gCount + sum[gLastIndex] + pCount + sum[pLastIndex] + mCount + sum[mLastIndex];
    }
}