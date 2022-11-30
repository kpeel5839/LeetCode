import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        boolean[] alreadyExistNumberOfOccurrences = new boolean[arr.length + 1];
        Map<Integer, Integer> countNumberOfOccurrences = new HashMap<>();  

        for (int i = 0; i < arr.length; i++) {
            int numberOfOccurrences = countNumberOfOccurrences.getOrDefault(arr[i], 0);
            countNumberOfOccurrences.put(arr[i], numberOfOccurrences + 1);
        }

        for (Integer key : countNumberOfOccurrences.keySet()) {
            if (alreadyExistNumberOfOccurrences[countNumberOfOccurrences.get(key)]) {
                return false;
            }

            alreadyExistNumberOfOccurrences[countNumberOfOccurrences.get(key)] = true;
        }

        return true;
    }
}