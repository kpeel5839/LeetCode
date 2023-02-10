class Solution {
    public int distanceBetweenTwoPosition(int[] firstPosition, int[] secondPosition) {
        return Math.abs(firstPosition[0] - secondPosition[0]) + Math.abs(firstPosition[1] - secondPosition[1]);    
    }
    
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        List<int[]> water = new ArrayList<>();
        List<int[]> land = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    water.add(new int[] {i, j});
                }
                
                if (grid[i][j] == 1) {
                    land.add(new int[] {i, j});
                }
            }
        }
        
        if (water.size() == 0 || land.size() == 0) {
            return -1;
        }
        
        int answer = 0;
        for (int[] waterPoint : water) {
            int minDistance = Integer.MAX_VALUE;
            
            for (int[] landPoint : land) {
                minDistance = Math.min(minDistance, distanceBetweenTwoPosition(waterPoint, landPoint));
                
                if (minDistance <= answer) {
                    break;
                }
            }
            
            answer = Math.max(answer, minDistance);
        }
        
        return answer;
    }
}