class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        for (int i = 0; i < batteryPercentages.length; i++) {
            for (int j = i + 1; j < batteryPercentages.length; j++) {
                if (0 < batteryPercentages[i]) {
                    batteryPercentages[j]--;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (0 < batteryPercentages[i]) {
                answer++;
            }
        }
        return answer;
    }
}