import java.util.*;

class Solution {

    public int sumSubarrayMins(int[] arr) {
        Stack<int[]> s = new Stack<>(); // {count, value}
        int MOD = 1_000_000_007;
        int stackSum = 0;
        int answer = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int productCount = 1;
            
            while (!s.isEmpty() && s.peek()[1] > arr[i]) {
                int[] v = s.pop();
                stackSum -= (v[0] * v[1]);
                productCount += v[0];
            }
            
            stackSum += (arr[i] * productCount);
            s.push(new int[] {productCount, arr[i]});
            answer = (answer + stackSum) % MOD;
        }
        
        return answer;
    }
    
}