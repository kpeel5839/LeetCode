class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        int start = 0;
        int index = 0;    
        int nowGasAmount = 0;
        
        while (start < size) {
            nowGasAmount += (gas[index % size] - cost[index % size]);
            
            if (nowGasAmount >= 0) {
                if ((start + size - 1) == index) { // 완전 다 돈 경우
                    return start;
                }
                
                index++;
            }
            
            if (nowGasAmount < 0) { // 끝난 경우
                index++;
                start = index;
                nowGasAmount = 0;
            }
        }
        
        return -1;
    }
}