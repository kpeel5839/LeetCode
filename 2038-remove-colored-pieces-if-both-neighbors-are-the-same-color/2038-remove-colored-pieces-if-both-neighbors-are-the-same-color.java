class Solution {
    public boolean winnerOfGame(String colors) {
        int aCount = 0;
        int bCount = 0;
        int aTotal = 0;
        int bTotal = 0;
        
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            
            if (c == 'A') {
                aCount++;

                if (3 <= bCount) {
                    bTotal += bCount - 2;
                }
                
                bCount = 0;
            } else {
                bCount++;
                
                if (3 <= aCount) {
                    aTotal += aCount - 2;
                }
                
                aCount = 0;
            }
        }

        if (3 <= aCount) {
            aTotal += aCount - 2;
        }

        if (3 <= bCount) {
            bTotal += bCount - 2;
        }
        
        return bTotal < aTotal;
    }
}