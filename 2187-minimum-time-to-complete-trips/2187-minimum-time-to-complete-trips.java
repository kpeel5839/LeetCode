class Solution {
    public boolean isPossible(int[] time, int totalTrips, long pivotTime) {
        long sum = 0;
        
        for (int i = 0; i < time.length; i++) {
            sum += (pivotTime / time[i]);
            
            if (totalTrips <= sum) {
                return true;
            }
        }
        
        return false;
    }
    
    public long minimumTime(int[] time, int totalTrips) {    
        long left = 1;
        long right = (long) Math.pow(10, 14);
        long answer = -1;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (isPossible(time, totalTrips, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
            
        return answer;
    }
}