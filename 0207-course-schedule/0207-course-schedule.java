class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        int[] entry = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            g.get(prerequisites[i][1]).add(prerequisites[i][0]);
            entry[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < entry.length; i++) {
            if (entry[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int c = q.poll();
            count++;
            
            for (Integer next : g.get(c)) {
                entry[next]--;
                
                if (entry[next] == 0) {
                    q.add(next);
                }
            }
        }
        
        return count == numCourses;
    }
}