class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String>list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(Integer.toString(i));
        }
        Collections.sort(list);
        return list.stream().map(Integer::parseInt).toList();
    }
}