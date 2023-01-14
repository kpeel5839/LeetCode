class Solution {
    public int[] parent = new int['z' - 'a' + 1];
    public List<ArrayList<Integer>> graph = new ArrayList<>();
    public boolean[] visited = new boolean['z' - 'a' + 1];
    
    public int find(int index) {
        if (parent[index] == index) {
            return parent[index];    
        }
        
        parent[index] = find(parent[index]);
        return parent[index];
    }
    
    public void union(int firstIndex, int secondIndex) {    
        if (firstIndex <= secondIndex) {
            parent[secondIndex] = firstIndex;        
        }
        
        if (firstIndex > secondIndex) {
            parent[firstIndex] = secondIndex;
        }
    }
    
    public int charToIndex(char character) {
        return character - 'a';
    }
    
    public char indexToChar(int index) {
        return (char) (index + 'a');
    }
    
    public void startFindUnion(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            int indexOfS1 = find(charToIndex(s1.charAt(i)));
            int indexOfS2 = find(charToIndex(s2.charAt(i)));
            
            if (indexOfS1 != indexOfS2) {
                union(indexOfS1, indexOfS2);
            }
        }
    }
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        startFindUnion(s1, s2);
        
        for (int i = 0; i < baseStr.length(); i++) {
            answer.append(indexToChar(find(charToIndex(baseStr.charAt(i)))));
        }
        
        return answer.toString();
    }
}