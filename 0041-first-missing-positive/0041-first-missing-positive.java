import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int v = Math.abs(nums[i]);
            if (n < v) {
                continue;
            }
            if (nums[v - 1] < 0) {
                continue;
            }
            nums[v - 1] *= -1;
        }
        for (int i = 0; i < n; i++) {
            if (0 < nums[i]) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
