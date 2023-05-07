class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] o) {
        List<Integer> ll = new ArrayList<>();
        int[] ans = new int[o.length];
        for (int i = 0; i < o.length; i++) {
            if (ll.isEmpty()) {
                ll.add(o[i]);
                ans[i] = 1;
            } else {
                if (ll.get(ll.size() - 1) <= o[i]) {
                    ll.add(o[i]);
                    ans[i] = ll.size();
                } else {
                    int l = 0;
                    int r = ll.size() - 1;
                    int idx = 0;
                    
                    while (l <= r) {
                        int m = (l + r) / 2;
                        
                        if (o[i] < ll.get(m)) {
                            idx = m;
                            r = m - 1;
                        } else {
                            l = m + 1;
                        }
                    }
                    
                    ll.set(idx, o[i]);
                    ans[i] = idx + 1;
                }
            }
        }
        
        return ans;
    }
}