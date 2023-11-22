class Solution {
    
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (!m.containsKey(i + j)) {
                    m.put(i + j, new ArrayList<>());
                }
                
                m.get(i + j).add(nums.get(i).get(j));
            }
        }

        List<Map.Entry<Integer, List<Integer>>> entry = new ArrayList<>(m.entrySet());
        Collections.sort(entry, (o1, o2) -> o1.getKey() - o2.getKey());
        for (Map.Entry<Integer, List<Integer>> list : entry) {
            List<Integer> value = list.getValue();
            for (int i = value.size() - 1; 0 <= i; i--) {
                ans.add(value.get(i));
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

}