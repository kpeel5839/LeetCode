class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]) {
                    return 1;
                }
                
                return -1;
            }
            
            return -1;
        });
        
        int minimumNumberOfArrows = 0;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                minimumNumberOfArrows++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        
        return minimumNumberOfArrows + 1; // 마지막을 못세는 문제가 있어서 + 1 을 해서 return
    }
}