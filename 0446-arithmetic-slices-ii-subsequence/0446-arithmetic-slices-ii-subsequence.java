import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int size = nums.length;
        Map<Integer, Integer>[] frequencyOfDiff = new Map[size];
        
        for (int i = 0; i < size; i++) {
            frequencyOfDiff[i] = new HashMap<>();
        } 

        int answer = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                long commonDiff = (long) nums[i] - (long) nums[j];
                
                if (commonDiff < Integer.MIN_VALUE || commonDiff > Integer.MAX_VALUE) {
                    continue;   
                }

                int diff = (int) commonDiff;
                int previousFrequencyOfDiff = frequencyOfDiff[j].getOrDefault(diff, 0);
                answer += previousFrequencyOfDiff;
                frequencyOfDiff[i].put(diff, frequencyOfDiff[i].getOrDefault(diff, 0) + previousFrequencyOfDiff + 1);
            }        
        }

        return answer;
    }
}