class Solution {
    public boolean isPossible(int limit, int[] weights, int days) {
        int index = 0;
        
        for (int i = 0; i < days; i++) {
            int sum = 0;
            while (index != weights.length) {
                sum += weights[index];
                
                if (limit < sum) {
                    break;
                }
                
                index++;
            }
        }
        
        return index == weights.length;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        
        int left = 1;
        int right = sum;
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (isPossible(mid, weights, days)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;   
            }
        }
        
        return answer;
    }
}