import java.util.*;

class Solution {
    public int[][] maximumRobFromHere;
    
    public int getMaximumRobFromHere(int[] houses, int nowHouseNumber, int isPossibleRobThisHouse) {
        if (nowHouseNumber >= houses.length) {
            return 0;
        }
        
        // isPossibleRobThisHouse = 0 이면 가능, 1 이면 불가능
        if (maximumRobFromHere[isPossibleRobThisHouse][nowHouseNumber] != -1) {  
            return maximumRobFromHere[isPossibleRobThisHouse][nowHouseNumber];
        }
        
        maximumRobFromHere[isPossibleRobThisHouse][nowHouseNumber] = 0;
        if (isPossibleRobThisHouse == 0) {
            maximumRobFromHere[isPossibleRobThisHouse][nowHouseNumber] = Math.max(getMaximumRobFromHere(houses, nowHouseNumber + 1, 1) + houses[nowHouseNumber], getMaximumRobFromHere(houses, nowHouseNumber + 1, 0));        
        } else {
            maximumRobFromHere[isPossibleRobThisHouse][nowHouseNumber] = getMaximumRobFromHere(houses, nowHouseNumber + 1, 0);
        }
        
        return maximumRobFromHere[isPossibleRobThisHouse][nowHouseNumber];
    }
    
    public int rob(int[] houses) {
        maximumRobFromHere = new int[2][houses.length];
        Arrays.fill(maximumRobFromHere[0], -1);
        Arrays.fill(maximumRobFromHere[1], -1);
        
        return getMaximumRobFromHere(houses, 0, 0);
    }
}