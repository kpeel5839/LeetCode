class Solution {
    public boolean checkStraightLine(int[][] c) {
        Arrays.sort(c, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } 
            
            return o1[0] - o2[0];
        });
        
        Set<Integer> setY = new HashSet<>();
        Set<Integer> setX = new HashSet<>();
        
        for (int i = 0; i < c.length; i++) {
            setX.add(c[i][0]);
            setY.add(c[i][1]);
        }
        
        if (setX.size() == 1 || setY.size() == 1) {
            return true;
        }
        
        double angle = (double) (c[1][1] - c[0][1]) / (double) (c[1][0] - c[0][0]);
        
        for (int i = 1; i < c.length - 1; i++) {
            double a = (double) (c[i + 1][1] - c[i][1]) / (double) (c[i + 1][0] - c[i][0]);
            
            if (angle != a) {
                return false;
            }
        }
        
        return true;
    }
}