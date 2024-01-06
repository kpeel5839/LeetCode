import java.util.*;

class Solution {
    int[][] jobs;
    int[] maxProfit;

    public int findLowerBoundIndex(int limitOfIndex, int findNumber) { // find lower bound index
        // 여기서는 lower bound 로 찾은 것을 넣어줄 것이다.
        int left = 0;
        int right = limitOfIndex; // 현재의 인덱스를 넣어줄 것이다.
        int indexOfResult = 0;

        while (left <= right) {
            // 작은 놈을 찾기 위해서는 left 를 계속 answer 로 집어넣어야함
            int middle = (left + right) / 2;
            
            if (jobs[middle][1] <= findNumber) {
                left = middle + 1;
                indexOfResult = middle;
            } else {
                right = middle - 1;  
            }
        }

        return indexOfResult;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new int[startTime.length + 1][3]; // {startTime, endTime, profit}
        maxProfit = new int[startTime.length + 1];
        jobs[0][1] = -1; // 오름차순 정렬이니까, 가장 마지막은 남아있어야함, profit 은 0으로

        for (int i = 1; i < jobs.length; i++) {
            jobs[i][0] = startTime[i - 1];
            jobs[i][1] = endTime[i - 1];
            jobs[i][2] = profit[i - 1];      
        }

        Arrays.sort(jobs, (o1, o2) -> o1[1] - o2[1]);
        int maxProfitUntilNow = 0;
        
        // 이제 여기서부터 값들을 처리하기만 하면 된다.
        for (int i = 1; i < jobs.length; i++) {
            // 일단 먼저 본인의 endTime 의 lower bound 를 찾는다.
            // 그리고 startTime 의 lower bound 를 찾으면 된다.        
            int lowerBoundOfStartTime = findLowerBoundIndex(i, jobs[i][0]);
            
            // 그리고 startTime 의 lowerBound 의 maxProfit 과, 현재 본인이 가진 profit 을 더해주고
            // 또 lowerBoundOfEndTime 으로 dp[lowerBoundOfEndTime] 으로 max 값을 비교해준다.
            maxProfit[i] = Math.max(maxProfitUntilNow, maxProfit[lowerBoundOfStartTime] + jobs[i][2]);
            maxProfitUntilNow = Math.max(maxProfitUntilNow, maxProfit[i]);
        }

        return maxProfit[jobs.length - 1];
    }
}