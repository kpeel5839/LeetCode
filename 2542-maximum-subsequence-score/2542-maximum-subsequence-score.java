class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new int[] {nums1[i], nums2[i]});
        }
        
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);
        long[] sums = new long[n];
        PriorityQueue<Long> min = new PriorityQueue<>();
        long sum = 0;
        
        for (int i = n - 1; n - 1 - (k - 1) < i; i--) {
            sum += list.get(i)[0];
            sums[i] = sum;
            min.add((long) list.get(i)[0]);
        }
        
        for (int i = n - 1 - (k - 1); 0 <= i; i--) {
            if (!min.isEmpty()) {
                if (min.peek() < list.get(i)[0]) {
                    sum -= min.poll();
                    sum += list.get(i)[0];
                    min.add((long) list.get(i)[0]);
                }
            }
            
            sums[i] = sum;
        }
        
        long ans = 0;
        for (int i = 0; i < n - (k - 1); i++) {
            long v = list.get(i)[1];
            long vv = list.get(i)[0];
            
            if (i != n - 1) {
                vv += sums[i + 1];
            }
            
            ans = Math.max(ans, v * vv);
        }
        
        return ans;
    }
}