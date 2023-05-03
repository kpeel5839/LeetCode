class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set[] c = new HashSet[2];
        Set[] s = new HashSet[2];  
        
        for (int i = 0; i < 2; i++) {
            c[i] = new HashSet<>();
            s[i] = new HashSet<>();
        }
        
        Arrays.stream(nums1).forEach(v -> c[0].add(v));
        Arrays.stream(nums2).forEach(v -> c[1].add(v));
        Arrays.stream(nums1).filter(v -> !c[1].contains(v)).forEach(v -> s[0].add(v));
        Arrays.stream(nums2).filter(v -> !c[0].contains(v)).forEach(v -> s[1].add(v));
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(s[0]));
        ans.add(new ArrayList<>(s[1]));
        
        return ans;
    }
}