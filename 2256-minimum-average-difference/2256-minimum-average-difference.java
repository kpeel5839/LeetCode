import java.util.*;

class Solution {
    public int minimumAverageDifference(int[] nums) {
        long[] sectionSum = new long[nums.length];
        sectionSum[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sectionSum[i] = (long) (nums[i] + sectionSum[i - 1]);
        }
        
        long minimumAverage = Long.MAX_VALUE;
        int minimumAverageIndex = -1;
        
        for (int i = 0; i < nums.length; i++) {
            long averageBetween = 0;
            
            if (i != nums.length - 1) {
                averageBetween = (sectionSum[i] / (i + 1)) - ((sectionSum[nums.length - 1] - sectionSum[i]) / (nums.length - (i + 1)));                        
            } else {
                averageBetween = (sectionSum[i] / (i + 1));
            }
            
            averageBetween = Math.abs(averageBetween);
            
            if (minimumAverage > averageBetween) {
                minimumAverage = averageBetween;
                minimumAverageIndex = i;            
            }
        }
        
        return minimumAverageIndex;
    }
}