import java.util.HashMap;
import java.util.Map;

class Solution {
    public Map<Integer, Integer> m = new HashMap<>();

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public void dfs(int[] nums, int v, int index, int goal, int c) {                        
        if (goal == c) {
            cal(v, nums, goal / 2);
            return;
        }
        
        if (nums.length - (index + 1) < (goal - c)) {
            return;
        }

        if (nums.length - 1 <= index) {
            return;
        }

        for (int i = index + 1; i < nums.length; i++) {
            dfs(nums, v | (1 << i), i, goal, c + 1);            
        }
    }

    public void cal(int bi, int[] nums, int multiple) {
        int max = 0;                

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = 1 << i;
                int b = 1 << j;

                if ((bi & a) != 0 && (bi & b) != 0) {                    
                    int newBi = ((1 << nums.length) - 1) ^ (a | b);                                    
                    int bibi = bi;
                    int newBibi = (bibi & newBi);                    
                    int v = gcd(nums[i], nums[j]);
                    max = Math.max(max, multiple * v + m.get(newBibi));
                }
            }
        }

        m.put(bi, max);
    }

    public int maxScore(int[] nums) {
        m.put(0, 0);

        for (int i = 1; i <= nums.length / 2; i++) {
            for (int j = 0; j < nums.length - (i * 2 - 1); j++) {
                dfs(nums, 1 << j, j, i * 2, 1);
            }
        }
        
        return m.get((1 << nums.length) - 1);
    }
}