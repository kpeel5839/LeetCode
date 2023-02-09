class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] set = new HashSet['z' - 'a' + 1];
        
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            set[i] = new HashSet<>();
        }
        
        for (int i = 0; i < ideas.length; i++) {
            set[ideas[i].charAt(0) - 'a'].add(ideas[i].substring(1));
        }
        
        int[][] isSame = new int['z' - 'a' + 1]['z' - 'a' + 1];
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            for (String s : set[i]) {
                for (int j = i + 1; j < 'z' - 'a' + 1; j++) {
                    if (set[j].contains(s)) {
                        isSame[i][j]++;
                    }
                }
            }
        }
        
        long result = 0;
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            for (int j = i + 1; j < 'z' - 'a' + 1; j++) {
                result += (set[i].size() - isSame[i][j]) * (set[j].size() - isSame[i][j]) * 2;
            }    
        }
        
        return result;
    }
}