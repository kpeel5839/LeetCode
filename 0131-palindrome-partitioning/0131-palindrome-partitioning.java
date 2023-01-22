class Solution {
    Set<List<String>> notDuplicate = new HashSet<>();
    
    public void brute(List<Integer> seperate, String s, int index) {
        addAnswer(new ArrayList<>(seperate), s);
        
        for (int i = index + 1; i < s.length(); i++) {
            List<Integer> newSeperate = new ArrayList<>(seperate);
            newSeperate.add(i);
            brute(newSeperate, s, i);
        }
    }
    
    public void addAnswer(List<Integer> seperate, String s) {
        seperate.add(s.length());
        String[] splitS = new String[seperate.size() - 1];
        
        for (int i = 0; i < splitS.length; i++) {
            splitS[i] = s.substring(seperate.get(i), seperate.get(i + 1));
            
            if (!isPalindrome(splitS[i])) {
                return;
            }
        }
        
        List<String> addList = new ArrayList<>();
        for (int i = 0; i < splitS.length; i++) {
            addList.add(splitS[i]);
        }
        
        notDuplicate.add(addList);
    }
    
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        
        int index = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() != s.charAt(index++)) {
                return false;
            }
        }
        
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<Integer> seperate = new ArrayList<>();
        seperate.add(0);
        brute(seperate, s, 0);
        
        List<List<String>> answer = new ArrayList<>();
        for (List<String> component : notDuplicate) {
            answer.add(component);
        }
        
        return answer;
    }
}