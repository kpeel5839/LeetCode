class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        int fuel = 0;
        
        while (mainTank != 0) {
            ans += 10;
            mainTank--;
            fuel++;
            
            if (fuel % 5 == 0 && additionalTank != 0) {
                mainTank++;
                additionalTank--;
            }
        }
        
        return ans;
    }
}