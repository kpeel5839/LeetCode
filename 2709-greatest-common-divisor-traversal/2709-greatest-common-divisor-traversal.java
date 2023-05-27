class Solution {
    public int n;
    public int[] p;
    public int[] count;
    
    public int find(int x) {
        if (p[x] == x) {
            return x;
        }
        
        return p[x] = find(p[x]);
    }
    
    public void union(int a, int b) {
        if (a == b) {
            return;
        }
        
        if (count[a] < count[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        p[b] = a;
        count[a] += count[b];
    }
    
    public boolean canTraverseAllPairs(int[] nums) {
        n = nums.length;
        p = new int[n];
        count = new int[n];
        
        for (int i = 0; i < n; i++) {
            p[i] = i;
            count[i] = 1;
        }
        
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int div = 2; div * div <= nums[i]; div++) {
                if (nums[i] % div == 0) {
                    if (m.containsKey(div)) {
                        int a = find(i);
                        int b = find(m.get(div));
                        
                        if (a != b) {
                            union(a, b);
                        }
                    } else {
                        m.put(div, i);
                    }
                    
                    while (nums[i] % div == 0) {
                        nums[i] /= div;
                    }
                }
            }
            
            if (nums[i] != 1) {
                if (m.containsKey(nums[i])) {
                    int a = find(i);
                    int b = find(m.get(nums[i]));
                    
                    if (a != b) {
                        union(a, b);
                    }
                } else {
                    m.put(nums[i], i);
                }
            }
        }
        
        return count[find(0)] == n;
    }
}