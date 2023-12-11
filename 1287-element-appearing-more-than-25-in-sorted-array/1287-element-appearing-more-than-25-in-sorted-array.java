class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
            
            if (0.25 < ((double) count.get(arr[i]) / (double) arr.length)) {
                return arr[i];
            }
        }
        
        return -1;
    }
}