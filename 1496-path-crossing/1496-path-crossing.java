class Solution {
    
    public class Point {
        
        int y;
        int x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            
            return this.y == point.y &&  this.x == point.x;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
        
        @Override
        public String toString() {
            return "y : " + y + " x : " + x;
        }
    }
    
    public boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        Map<Character, Integer> m = new HashMap<>(Map.of('N', 0, 'S', 1, 'E', 2, 'W', 3));
        int[] dy = new int[] {-1, 1, 0, 0};
        int[] dx = new int[] {0, 0, 1, -1};
        int y = 0;
        int x = 0;
        set.add(new Point(y, x));
        
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            y = y + dy[m.get(c)];
            x = x + dx[m.get(c)];
            
            Point newPoint = new Point(y, x);
            
            if (set.contains(newPoint)) {
                return true;
            }
            
            set.add(newPoint);
        }
        
        return false;
    }
}