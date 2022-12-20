class Solution {
    
    public void dfs(List<List<Integer>> rooms, boolean[] visited, int current) {
        if (visited[current]) {
            return;
        }
        
        visited[current] = true;

        for (Integer next : rooms.get(current)) {        
            dfs(rooms, visited, next);
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        boolean isVisitedAllRoom = true;    
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                isVisitedAllRoom = false;
                break;
            }
        }
        
        return isVisitedAllRoom;
    }
}