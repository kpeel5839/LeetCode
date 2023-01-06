class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        
        int canBuyCount = 0;
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            
            if (coins < 0) {
                break;
            }
            
            canBuyCount++;
        }
        
        return canBuyCount;
    }
}