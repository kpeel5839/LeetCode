class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = 0;
        int limit = piles.length / 3;
        int answer = 0;
        
        for (int i = piles.length - 2; 0 <= i; i -= 2) {
            count++;
            answer += piles[i];
            
            if (count == limit) {
                break;
            }
        }
        
        return answer;
    }
}