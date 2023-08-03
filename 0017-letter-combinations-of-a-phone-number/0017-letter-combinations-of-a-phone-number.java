class Solution {
    public Map<Integer, List<String>> map = Map.of(
        2, List.of("a", "b", "c"),
        3, List.of("d", "e", "f"),
        4, List.of("g", "h", "i"),
        5, List.of("j", "k", "l"),
        6, List.of("m", "n", "o"),
        7, List.of("p", "q", "r", "s"),
        8, List.of("t", "u", "v"),
        9, List.of("w", "x", "y", "z")
    );
    public List<String> ans = new ArrayList<>();
    public String digits;
    
    public void dfs(String s, int index) {
        if (index == digits.length()) {
            ans.add(s);
            return;
        }
        
        for (String ss : map.get(digits.charAt(index) - '0')) {
            String newString = s + ss;
            dfs(newString, index + 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        
        this.digits = digits;
        dfs("", 0);
        return ans;
    }
}