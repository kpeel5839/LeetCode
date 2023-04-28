class Solution {    
    public int[] p;
    public boolean similar(String s1, String s2) {
        int diff = 0;
        
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
    
    public int find(int x) {
        if (p[x] == x) {
            return x;
        }
        
        return p[x] = find(p[x]);
    }
    
    public void union(int a, int b) {
        p[b] = a;
    }
    
    public int numSimilarGroups(String[] strs) {
        p = new int[strs.length];
        
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        
        for (int i = 1; i < strs.length; i++) {                    
            for (int j = 0; j < i; j++) {
                if (similar(strs[j], strs[i])) {                    
                    union(find(j), find(i));
                }    
            }
        }
        
        Set<Integer> set = new HashSet<>();    
        for (int i = 0; i < p.length; i++) {
            set.add(find(i));
        }
        
        return set.size();
    }
}