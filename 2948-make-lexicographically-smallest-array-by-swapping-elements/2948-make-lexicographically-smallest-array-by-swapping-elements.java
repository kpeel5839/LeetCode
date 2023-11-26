class Solution {

    public int[] lower;
    public int[] upper;
    
    public int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    public void lowerUnion(int[] parent, int a, int b) {
        if (a < 0 || b < 0) {
            return;
        }
        
        a = find(parent, a);
        b = find(parent, b);
        parent[Math.max(a, b)] = Math.min(a, b);
    }

    public void upperUnion(int[] parent, int a, int b) {
        if (parent.length == a || parent.length == b) {
            return;
        }
        
        a = find(parent, a);
        b = find(parent, b);
        parent[Math.min(a, b)] = Math.max(a, b);
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        Map<Integer, Integer> m = new HashMap<>();
        lower = new int[n];
        upper = new int[n];

        for (int i = 0; i < n; i++) { 
            arr[i] = new int[] {nums[i], i};
            lower[i] = i;
            upper[i] = i;
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        
        for (int i = 0; i < n; i++) {
            m.put(arr[i][1], i);
        }
        
        for (int i = n - 1; 1 <= i; i--) {
            if (arr[i][0] - arr[i - 1][0] <= limit) {
                lowerUnion(lower, i, i - 1);
            }
        }

        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int lowerIndex = find(lower, m.get(index[i]));
            int upperIndex = find(upper, lowerIndex);
            int swapIndex = arr[upperIndex][1];
            int tmp = index[i];
            index[i] = swapIndex;
            if (i < swapIndex) {
                index[swapIndex] = tmp;
            }
            upperUnion(upper, upperIndex, upperIndex + 1);
        }
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[index[i]];
        }
        return ans;
    }
}