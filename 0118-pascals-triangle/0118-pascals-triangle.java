class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> addList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int a = j == 0 ? 0 : list.get(i - 1).get(j - 1);
                int b = j == i ? 0 : list.get(i - 1).get(j);
                addList.add(a + b);
            }
            list.add(addList);
        }
        
        return list;
    }
}