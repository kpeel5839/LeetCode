class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int sum = 0;
        int answer = 0;
        int index = 0;
        
        while (sum < target) {
            if (index == coins.length) {
                sum += (sum + 1);
                answer++;
                continue;
            } 
            
            if (coins[index] <= sum + 1) {
                sum += coins[index++];
            } else {
                sum += (sum + 1);
                answer++;
            }
        }
        
        return answer;
    }
}