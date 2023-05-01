class Solution {
    public class Vertex {
        int y;
        int x;
        
        Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
        @Override
        public boolean equals(Object o) {
            Vertex v = (Vertex) o;
            return v.y == this.y && v.x == this.x;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
    
    public class Path {
        Vertex v;
        int c;
        
        Path(Vertex v, int c) {
            this.v = v;
            this.c = c;        
        }
    }
    
    public int getDis(Vertex start, Vertex target) {
        return Math.abs(target.x - start.x) + Math.abs(target.y - start.y);
    }
    
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Map<Vertex, ArrayList<Path>> m = new HashMap<>();
        Map<Vertex, Integer> v = new HashMap<>();
        
        m.put(new Vertex(start[0], start[1]), new ArrayList<>());
        m.put(new Vertex(target[0], target[1]), new ArrayList<>());
        v.put(new Vertex(target[0], target[1]), Integer.MAX_VALUE);
        
        for (int i = 0; i < specialRoads.length; i++) {
            m.put(new Vertex(specialRoads[i][0], specialRoads[i][1]), new ArrayList<>());
            m.put(new Vertex(specialRoads[i][2], specialRoads[i][3]), new ArrayList<>());
            v.put(new Vertex(specialRoads[i][0], specialRoads[i][1]), Integer.MAX_VALUE);
            v.put(new Vertex(specialRoads[i][2], specialRoads[i][3]), Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < specialRoads.length; i++) {
            Vertex a = new Vertex(specialRoads[i][0], specialRoads[i][1]);
            Vertex b = new Vertex(specialRoads[i][2], specialRoads[i][3]);
            
            m.get(a).add(new Path(b, specialRoads[i][4]));
        }
        
        for (Map.Entry<Vertex, ArrayList<Path>> e : m.entrySet()) {
            Vertex eKey = e.getKey();
            for (Map.Entry<Vertex, ArrayList<Path>> ee : m.entrySet()) {
                Vertex eeKey = ee.getKey();
                
                if (eKey.equals(eeKey)) {
                    continue;
                }
                
                // 그게 아니라면 서로 Path 를 만들어주어야하
                m.get(eKey).add(new Path(eeKey, getDis(eKey, eeKey)));
                m.get(eeKey).add(new Path(eKey, getDis(eKey, eeKey)));
            }    
        }
        
        // 여기까지했으면 끝났음
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        q.add(new int[] {start[0], start[1], 0});
        v.put(new Vertex(start[0], start[1]), 0);
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            Vertex pp = new Vertex(p[0], p[1]);
            
            if (v.get(pp) < p[2]) {
                continue;
            }
            
            if (new Vertex(target[0], target[1]).equals(pp)) {
                return p[2];
            }
            
            for (Path next : m.get(pp)) {
                if (p[2] + next.c < v.get(next.v)) {
                    q.add(new int[] {next.v.y, next.v.x, p[2] + next.c});
                    v.put(next.v, p[2] + next.c);
                }
            }
        }
        
        return -1;
    }
}