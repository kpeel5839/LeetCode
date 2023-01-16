class Solution {
    public boolean isOverlap(int[] compare, int[] pivot) {
        return (pivot[0] <= compare[0] && compare[0] <= pivot[1])
            || (pivot[0] <= compare[1] && compare[1] <= pivot[1])
            || (compare[0] <= pivot[0] && pivot[1] <= compare[1]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = Integer.MAX_VALUE;
        int overlapCount = 0;
        int firstLargeThenIntervalEnd = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (isOverlap(intervals[i], newInterval)) {            
                start = Math.min(start, i);
                overlapCount++;
            }
            
            if (intervals[i][1] < newInterval[0]) {
                firstLargeThenIntervalEnd = Math.max(firstLargeThenIntervalEnd, i);
            }
        }
        
        int[][] result = new int[intervals.length - overlapCount + 1][2];
        
        if (overlapCount == 0) {
            if (firstLargeThenIntervalEnd == -1) {
                result[0] = newInterval;
                
                for (int i = 0; i < intervals.length; i++) {
                    result[i + 1] = intervals[i];
                }
            }
            
            if (firstLargeThenIntervalEnd != -1) {
                for (int i = 0; i <= firstLargeThenIntervalEnd; i++) {
                    result[i] = intervals[i];
                }
                
                result[firstLargeThenIntervalEnd + 1] = newInterval;
                
                for (int i = firstLargeThenIntervalEnd + 1; i < intervals.length; i++) {
                    result[i + 1] = intervals[i];
                }
            }
        }
        
        if (overlapCount != 0) {        
            for (int i = 0; i < start; i++) {
                result[i] = intervals[i];
            }
            
            int min = newInterval[0];
            int max = newInterval[1];
            for (int i = start; i < start + overlapCount; i++) {
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            }
            
            result[start] = new int[] {min, max};
            
            for (int i = start + overlapCount; i < intervals.length; i++) {
                result[++start] = intervals[i];
            }
        }
        
        return result;
    }
}