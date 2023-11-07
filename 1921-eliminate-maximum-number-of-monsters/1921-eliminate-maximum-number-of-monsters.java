class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] sum = new int[n];

        for (int i = 0; i < dist.length; i++) {
            int deadTime = 0;
            if (dist[i] % speed[i] == 0) {
                deadTime = dist[i] / speed[i];
            } else {
                deadTime = dist[i] / speed[i] + 1;
            }
            
            if (deadTime < n) {
                sum[deadTime]++;
            }
        }

        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];

            if (i < sum[i]) {
                return i;
            }
        }

        return dist.length;
    }
}