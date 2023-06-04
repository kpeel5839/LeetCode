class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> r = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        int rowCount = n;
        int colCount = n;
        long ans = 0;

        for (int i = queries.length - 1; 0 <= i; i--) {
            int index = queries[i][1];
            int val = queries[i][2];
            if (queries[i][0] == 0) {
                if (!r.contains(index)) {
                    r.add(index);
                    colCount--;
                    ans += (rowCount * val);
                }
            } else {
               if (!c.contains(index)) {
                    c.add(index);
                    rowCount--;
                    ans += (colCount * val); 
               } 
            } 
        }

        return ans;
    }
}