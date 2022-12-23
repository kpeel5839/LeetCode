class Solution {
    public int size;
    public int[] price;
    public int[][] maxProfitAfterThisDay;
    
    public int maxProfitByStatus(int day, int status) {
        // status : 0 = buy, 1 = sell, 2 = cooldown
        if (size == day) {
            return 0;
        }
        
        if (maxProfitAfterThisDay[status][day] != -1) {
            return maxProfitAfterThisDay[status][day];
        }
        
        if (status == 0) { // status = 0 인 경우 Buy or 넘어가기
            maxProfitAfterThisDay[status][day] = Math.max(maxProfitByStatus(day + 1, 1) - price[day], maxProfitByStatus(day + 1, 0));
        }
        
        if (status == 1) { // status = 1 인 경우 Sell or 넘어가기
            maxProfitAfterThisDay[status][day] = Math.max(maxProfitByStatus(day + 1, 2) + price[day], maxProfitByStatus(day + 1, 1));        
        }
        
        if (status == 2) { // status = 2 인 경우는 무조건 넘어가기
            maxProfitAfterThisDay[status][day] = maxProfitByStatus(day + 1, 0);
        }
                                                          
        return maxProfitAfterThisDay[status][day];
    }
    
    public int maxProfit(int[] prices) {
        size = prices.length;
        price = prices;
        maxProfitAfterThisDay = new int[3][size];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(maxProfitAfterThisDay[i], -1);
        }
        
        return maxProfitByStatus(0, 0);
    }
}