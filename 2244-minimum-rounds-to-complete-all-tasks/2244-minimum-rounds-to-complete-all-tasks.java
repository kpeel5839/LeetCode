class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> frequency = new HashMap<>();
        
        for (int i = 0; i < tasks.length; i++) {
            frequency.put(tasks[i], frequency.getOrDefault(tasks[i], 0) + 1);        
        }
        
        int answer = 0;
        for (Integer value : frequency.values()) {
            int count = 0;
            
            if (value == 1) {
                return -1;
            }
            
            if (value % 2 == 0) {
                answer = answer + (((value / 2) / 3) * 2) + ((value / 2) % 3);
            }
            
            if (value % 2 != 0) {
                value -= 3;
                answer = answer + (((value / 2) / 3) * 2) + ((value / 2) % 3) + 1;
            }
        }
        
        return answer;
    }
}