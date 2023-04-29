class Solution {
    public int[] p;
    
    public int find(int x) {
        if (p[x] == x) {
            return x;
        }
        
        return p[x] = find(p[x]);
    }
    
    public void union(int a, int b) {
        p[b] = a;
    }
    
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        p = new int[n];
        
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[] {queries[i][0], queries[i][1], queries[i][2], i};
        }
        
        Arrays.sort(queries, (o1, o2) -> o1[2] - o2[2]);
        Arrays.sort(edgeList, (o1, o2) -> o1[2] - o2[2]);
        
        boolean[] answer = new boolean[queries.length];    
        int index = 0;
        for (int[] q : queries) {            
            while (index < edgeList.length && edgeList[index][2] < q[2]) {            
                union(find(edgeList[index][0]), find(edgeList[index][1]));
                index++;
            }
            
            if (find(q[0]) == find(q[1])) {
                answer[q[3]] = true;
            }
        }
        
        return answer;
    }
}