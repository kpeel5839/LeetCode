class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            map.put(groupSizes[i], new ArrayList<>());
        }
       
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.get(groupSizes[i]);
            list.add(i);
            
            if (list.size() == groupSizes[i]) {
                ans.add(list);
                map.put(groupSizes[i], new ArrayList<>());
            }
        }
        
        return ans;
    }
}