import java.util.*;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (int i = 0; i < piles.length; i++) {
            queue.add(piles[i]);
        }        
        
        for (int i = 0; i < k; i++) {
            int divideNumber = queue.poll();
            divideNumber -= (divideNumber / 2);
            queue.add(divideNumber);                
        }
        
        int stonesOfAllPiles = 0;
        while (!queue.isEmpty()) {
            stonesOfAllPiles += queue.poll();
        }
        
        return stonesOfAllPiles;
    }
}