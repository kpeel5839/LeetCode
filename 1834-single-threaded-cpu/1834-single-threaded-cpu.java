import java.util.*;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] newTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            newTasks[i][0] = i;
            newTasks[i][1] = tasks[i][0];
            newTasks[i][2] = tasks[i][1];
        }
        
        Arrays.sort(newTasks, (o1, o2) -> o1[1] - o2[1]);
        int startTime = newTasks[0][1];
        PriorityQueue<int[]> scheduler = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            
            return o1[1] - o2[1];
        }); // {index, processTime}
        
        int tasksIndex = 0;
        int jobOrderIndex = 0;
        int[] jobOrder = new int[tasks.length];
        
        while (tasksIndex != tasks.length || !scheduler.isEmpty()) {   
            if (tasksIndex != tasks.length && (scheduler.isEmpty() || newTasks[tasksIndex][1] <= startTime)) {
                if (startTime < newTasks[tasksIndex][1]) {
                    startTime = newTasks[tasksIndex][1];                
                }
                
                scheduler.add(new int[] {newTasks[tasksIndex][0], newTasks[tasksIndex][2]});
                tasksIndex++;
                continue;
            }
            
            if (tasksIndex == tasks.length || startTime < newTasks[tasksIndex][1]) {
                int[] nowProcessJob = scheduler.poll();
                startTime += nowProcessJob[1];            
                jobOrder[jobOrderIndex++] = nowProcessJob[0];
            }
        }
        
        return jobOrder;
    }
}