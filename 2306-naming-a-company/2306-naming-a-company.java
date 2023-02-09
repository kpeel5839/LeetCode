class Solution {
    public long distinctNames(String[] ideas) {
        int range = 'z' - 'a' + 1;
        Set<String>[] set = new HashSet[range];
        
        for (int i = 0; i < range; i++) {
            set[i] = new HashSet<>();
        }
        
        for (int i = 0; i < ideas.length; i++) {
            set[ideas[i].charAt(0) - 'a'].add(ideas[i].substring(1));
        }
        
        int[][] sameCount = new int[range][range];
        for (int i = 0; i < range; i++) {
            for (String s : set[i]) {
                for (int j = i + 1; j < range; j++) {
                    if (set[j].contains(s)) {
                        sameCount[i][j]++;
                    }
                }
            }
        }
        
        long result = 0;
        for (int i = 0; i < range; i++) {
            for (int j = i + 1; j < range; j++) {
                result += (set[i].size() - sameCount[i][j]) * (set[j].size() - sameCount[i][j]) * 2;
            }
        }
        
        return result;
    }
}