class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
       
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i] - difference;
            int putValue = m.getOrDefault(target, 0) + 1;
            m.put(arr[i], Math.max(putValue, m.getOrDefault(arr[i], 0)));
            ans = Math.max(ans, m.get(arr[i]));
        }
        
        return ans; 
    }
}