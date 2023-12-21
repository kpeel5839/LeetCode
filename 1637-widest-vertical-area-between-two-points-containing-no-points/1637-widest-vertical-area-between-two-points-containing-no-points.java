class Solution {
    
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < points.length; i++) {
            set.add(points[i][0]);
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        int answer = 0;
        
        for (int i = 1; i < list.size(); i++) {
            answer = Math.max(answer, list.get(i) - list.get(i - 1));
        }
        
        return answer;
    }
    
}