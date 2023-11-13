class Solution {
    public int[][] merge(int[][] time) {
        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);
        
        int startTime = time[0][0];
        int endTime = time[0][1];
        List<int[]> ans = new ArrayList<>();

        for (int i = 1; i < time.length; i++) {
            if (time[i][0] <= endTime) {
                endTime = Math.max(time[i][1], endTime);
            } else {
                ans.add(new int[] {startTime, endTime});
                startTime = time[i][0];
                endTime = time[i][1];
            }
        }

        ans.add(new int[] {startTime, endTime});
        int[][] answer = new int[ans.size()][2];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;

    }
}