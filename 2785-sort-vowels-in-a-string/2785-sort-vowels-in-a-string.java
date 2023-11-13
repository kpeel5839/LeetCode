class Solution {
    public String sortVowels(String s) {
        Set<Character> set = new HashSet<>(
            Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );
        List<Character> strings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (set.contains(c)) {
                strings.add(c);
            }
        }
        
        Collections.sort(strings);
        int index = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                ans.append(strings.get(index++));
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}