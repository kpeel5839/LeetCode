class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        int start = 0;
        int index = 0;    
        int nowGasAmount = 0;
        int[] totalCost = new int[size]; 
        
        for (int i = 0; i < gas.length; i++) {
            totalCost[i] = gas[i] - cost[i];
        }
        
        while (start < size) {
            nowGasAmount += totalCost[index % size];
            
            if (nowGasAmount < 0) { // 끝난 경우
                index++;
                start = index;
                nowGasAmount = 0;
            } else { // 끝나지 않은 경우
                if ((start + size - 1) == index) { // 완전 다 돈 경우
                    return start;
                }
                
                index++;
            }
        }
        
        return -1;
    }
}