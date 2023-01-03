class Solution {
    public int minDeletionSize(String[] strs) {
        int deleteCount = 0;
        
        for (int j = 0; j < strs[0].length(); j++) {
            int max = strs[0].charAt(j);
            
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(j) < max) {
                    deleteCount++;
                    break;
                }
                
                max = strs[i].charAt(j);
            }
        }
        
        return deleteCount;
    }
}