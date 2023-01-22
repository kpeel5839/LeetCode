class Solution {
    Set<List<String>> notDuplicate = new HashSet<>();
    boolean[][] isPelindrome;
    
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
            
            if (!isPelindrome[seperate.get(i)][seperate.get(i + 1) - 1]) {
                return;
            }
        }
        
        List<String> addList = new ArrayList<>();
        for (int i = 0; i < splitS.length; i++) {
            addList.add(splitS[i]);
        }
        
        notDuplicate.add(addList);
    }
    
    public List<List<String>> partition(String s) {
        List<Integer> seperate = new ArrayList<>();
        isPelindrome = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < isPelindrome.length; i++) {        
            for (int j = 0; j < isPelindrome.length - i; j++) {
                if (i == 0) {
                    isPelindrome[j][j] = true;
                }
                
                if (i == 1) {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        isPelindrome[j][j + i] = true;
                    }
                }
                
                if (2 <= i) {
                    if (s.charAt(j) == s.charAt(j + i) && isPelindrome[j + 1][j + i - 1]) {
                        isPelindrome[j][j + i] = true;
                    }
                }
            }
        }

        seperate.add(0);
        brute(seperate, s, 0);
        
        List<List<String>> answer = new ArrayList<>();
        for (List<String> component : notDuplicate) {
            answer.add(component);
        }
        
        return answer;
    }
}