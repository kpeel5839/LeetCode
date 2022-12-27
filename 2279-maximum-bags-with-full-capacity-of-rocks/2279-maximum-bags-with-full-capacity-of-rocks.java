class Solution {
    public int getNumberOfMaximum(int[] remainCapacity, int additionalRocks) {
        Arrays.sort(remainCapacity);
        
        for (int i = 0; i < remainCapacity.length; i++) {
            additionalRocks -= remainCapacity[i];
            
            if (additionalRocks < 0) {
                return i;
            }
        }
        
        return remainCapacity.length;
    }
    
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remainCapacity = new int[capacity.length];
        
        for (int i = 0; i < capacity.length; i++) {
            remainCapacity[i] = capacity[i] - rocks[i];
        }
        
        return getNumberOfMaximum(remainCapacity, additionalRocks);
    }
}