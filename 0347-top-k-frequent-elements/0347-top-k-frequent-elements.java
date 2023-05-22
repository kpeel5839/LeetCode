class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.stream(nums)
            .forEach(v -> m.put(v, m.getOrDefault(v, 0) + 1));                                
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(m.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        return list.subList(0, k)
            .stream()
            .mapToInt(v -> v.getKey())
            .toArray();
    }
}