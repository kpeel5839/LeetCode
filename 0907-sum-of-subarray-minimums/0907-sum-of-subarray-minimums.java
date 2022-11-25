import java.util.*;

class Solution {
    final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        /*
        어떻게 해야할까?
        이 문제의 핵심은 boundary 를 구해서, 그 범위를 이용하여 계산하는 것이 핵심인 문제 
        */    
        Stack<int[]> monoStack = new Stack<>();
        long answer = 0;
        int arrSize = arr.length;    
        long[] left = new long[arrSize];
        long[] right = new long[arrSize];
        
        for (int i = 0; i < arrSize; i++) {
            int countOfsmallerThanThisIndex = 1; 
            
            while (!monoStack.empty() && monoStack.peek()[0] > arr[i]) { // 여기는 더 작은 것만 따지는 이유는 모두 같은 경우를 생각해보면 쉽다.
                countOfsmallerThanThisIndex += monoStack.pop()[1];
            }

            monoStack.push(new int[] {arr[i], countOfsmallerThanThisIndex});
            left[i] = countOfsmallerThanThisIndex;
        }

        monoStack.clear();    

        for (int i = arrSize - 1; i != -1; i--) {
                int countOfsmallerThanThisIndex = 1;
            
            while (!monoStack.empty() && monoStack.peek()[0] >= arr[i]) {
                countOfsmallerThanThisIndex += monoStack.pop()[1];            
            }

            monoStack.push(new int[] {arr[i], countOfsmallerThanThisIndex});
            right[i] = countOfsmallerThanThisIndex;        
        }

        for (int i = 0; i < arrSize; i++) {
            answer = (answer + arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) answer;
    }
}