class Solution {
    public Map<Integer, Integer> frequency = new HashMap<>();
    
    public int totalFruit(int[] fruits) {
        int left = 0;
        int answer = 0;
        
        for (int i = 0; i < fruits.length; i++) {
            if (frequency.size() >= 2 && !frequency.containsKey(fruits[i])) {
                while (frequency.size() >= 2) {
                    frequency.put(fruits[left], frequency.getOrDefault(fruits[left], 0) - 1);
                    
                    if (frequency.get(fruits[left]) == 0) {
                        frequency.remove(fruits[left]);
                    }
                    
                    left++;
                }
            }
        
            frequency.put(fruits[i], frequency.getOrDefault(fruits[i], 0) + 1);
            answer = Math.max(answer, i - left + 1);
        }
        
        return answer;
    }
}