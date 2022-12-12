import java.util.*;

class Solution {
    public int[] numberOfReachTopWay;
    public int getNumberOfReachTopWay(int top, int step) {
        if (step >= top) {
            if (step == top) {
                return 1;
            } else {
                return 0;
            }
        }
        
        if (numberOfReachTopWay[step] != -1) {
            return numberOfReachTopWay[step];
        }
        
        numberOfReachTopWay[step] = 0;
        numberOfReachTopWay[step] += getNumberOfReachTopWay(top, step + 1);
        numberOfReachTopWay[step] += getNumberOfReachTopWay(top, step + 2);
        return numberOfReachTopWay[step];
    }
        
    public int climbStairs(int n) {
        numberOfReachTopWay = new int[n + 1];
        Arrays.fill(numberOfReachTopWay, -1);
        return getNumberOfReachTopWay(n, 0);
    }
}