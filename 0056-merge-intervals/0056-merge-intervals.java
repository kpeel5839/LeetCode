class Solution {
    public int[][] merge(int[][] time) {
        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);
        int start=time[0][0];
        int end=time[0][1];
        List<int[]>resultRange=new ArrayList<>();
        for(int i=0;i<time.length;i++){
            if(end<time[i][0]){
                resultRange.add(new int[]{start,end});
                start=time[i][0];
                end=time[i][1];
                continue;
            }
            end=Math.max(end,time[i][1]);
        }
        resultRange.add(new int[]{start,end});
        int[][] answer=new int[resultRange.size()][2];
        for(int i=0;i<resultRange.size();i++){
          answer[i][0]=resultRange.get(i)[0];
          answer[i][1]=resultRange.get(i)[1];
        }
        return answer;
    }
}