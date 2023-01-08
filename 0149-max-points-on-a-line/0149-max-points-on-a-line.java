class Solution {
    public boolean isStraight(int[] first, int[] second, int[] third) {
        // 신발끈 공식
        int angle = (first[0] * second[1] + second[0] * third[1] + third[0] * first[1])
            - (first[1] * second[0] + second[1] * third[0] + third[1] * first[0]);
        
        return angle == 0;
    }
    
    public int maxPoints(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            
            return o1[0] - o2[0];
        });
        
        int answer = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int count = 2;
                for (int c = j + 1; c < points.length; c++) {
                    if (isStraight(points[i], points[j], points[c])) {
                        count++;
                    }
                }
                
                answer = Math.max(answer, count);
            }
        }
        
        return answer;
    }
}