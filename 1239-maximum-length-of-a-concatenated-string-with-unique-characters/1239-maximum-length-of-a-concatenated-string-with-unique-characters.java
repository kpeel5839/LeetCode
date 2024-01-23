class Solution {
    
    public List<String> arr;
    public Set<Character> set;
    public int answer = 0;
    
    public void dfs(int index) {
        if (index == arr.size()) {
            answer = Math.max(answer, set.size());
            return;
        }
        
        Set<Character> insertSet = new HashSet<>();
        for (int i = 0; i < arr.get(index).length(); i++) {
            char c = arr.get(index).charAt(i);
            if (set.contains(c)) {
                break;
            }
            insertSet.add(c);
        }
        
        if (insertSet.size() == arr.get(index).length()) {
            set.addAll(insertSet);
            dfs(index + 1);
            for (Character c : insertSet) {
                set.remove(c);
            }
        }
        
        dfs(index + 1);
    }
        
    public int maxLength(List<String> arr) {
        this.arr = arr;
        set = new HashSet<>();
        dfs(0);
        
        return answer;
    }
}