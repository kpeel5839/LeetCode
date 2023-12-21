class Solution {
    
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        int answer = 0;
        
        for (int i = 1; i < points.length; i++) {
            answer = Math.max(answer, points[i][0] - points[i - 1][0]);
        }
        
        return answer;
    }
    
}