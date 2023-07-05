class Solution {
    
    public int[] parent;
    public int[] count;
    
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        } 
        
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b) {
        parent[b] = a;
        count[a] += 1;
    }
    
    public int longestSubarray(int[] nums) {
        parent = new int[nums.length];
        count = new int[nums.length];
        int c = 0;
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ans = 1;
                count[i] = 1;
            } else {
                c++;
            }
            
            parent[i] = i;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1 && nums[i - 1] == 1) {
                int a = find(i - 1);
                int b = i;
                union(a, b);
                ans = Math.max(ans, count[a]);
            } 
        }

        if (c == 0) {
            ans--;
        } 

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                ans = Math.max(ans, count[find(i - 1)] + count[find(i + 1)]);
            }
        }
       
        return ans;
    }
    
}