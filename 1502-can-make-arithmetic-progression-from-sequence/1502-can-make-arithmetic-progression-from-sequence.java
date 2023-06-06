class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < arr.length - 1; i++) {
            set.add(arr[i + 1] - arr[i]);
        }
        
        return set.size() == 1;
    }
}