class Solution {    
    public int find(int x, int[] p) {
        if (p[x] == x) {
            return x;
        }
        
        return p[x] = find(p[x], p);
    }
    
    public void union(int a, int b, int[] p) {
        p[b] = a;
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            a[i] = i;
            b[i] = i;
        }
        
        Arrays.sort(edges, (o1, o2) -> o2[0] - o1[0]);
        int count = 0;
        
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            
            if (type == 3) { // all
                int a1 = find(edges[i][1], a);
                int a2 = find(edges[i][2], a);
                
                if (a1 != a2) { // 같은 집합이 아니라면, 추가
                    count++;
                    union(a1, a2, a);
                    union(find(edges[i][1], b), find(edges[i][2], b), b);
                }            
            } else if (type == 2) { // a
                int a1 = find(edges[i][1], a);
                int a2 = find(edges[i][2], a);
                
                if (a1 != a2) {
                    count++;
                    union(a1, a2, a);
                }
            } else { // b
                int b1 = find(edges[i][1], b);
                int b2 = find(edges[i][2], b);
                
                if (b1 != b2) {
                    count++;
                    union(b1, b2, b);
                }
            }
        }
        
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            aSet.add(find(i, a));
            bSet.add(find(i, b)); 
        }

        if (aSet.size() != 1 || bSet.size() != 1) {
            return -1;
        }

        return edges.length - count;
    }
}