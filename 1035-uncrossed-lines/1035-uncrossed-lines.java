class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        int[][] dp = new int[nums1.length][nums2.length];
        
        for (int i = 0; i < nums1.length; i++) {
            if (!m.containsKey(nums1[i])) {
                m.put(nums1[i], new ArrayList<>());
            }

            m.get(nums1[i]).add(i);
        }

        int ans = 0;    
        for (int i = 0; i < nums2.length; i++) {
            if (!m.containsKey(nums2[i])) {
                continue;
            }        

            for (Integer ii : m.get(nums2[i])) {
                int max = 0;
                for (int j = i - 1; 0 <= j; j--) {
                    if (!m.containsKey(nums2[j])) {
                        continue;
                    }
                
                    List<Integer> list = m.get(nums2[j]);                
                    int l = 0;
                    int r = list.size() - 1;
                    int idx = -1;
                    while (l <= r) {
                        int mid = (l + r) / 2;
                        
                        if (list.get(mid) < ii) {
                            l = mid + 1;
                            idx = mid;
                        } else {                        
                            r = mid - 1;
                        }
                    }                    
                    
                    if (idx != -1) {                        
                        max = Math.max(max, dp[list.get(idx)][j]);
                    }
                }

                dp[ii][i] = max + 1;
                ans = Math.max(ans, dp[ii][i]);
            }
        }

        return ans;
    }
}