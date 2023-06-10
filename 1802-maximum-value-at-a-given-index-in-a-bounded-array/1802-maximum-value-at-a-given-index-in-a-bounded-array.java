class Solution {
    public int n;
    public int index;
    public int maxSum;

    public boolean isPossible(long max) {
        int leftCount = index;
        int rightCount = n - 1 - index;
        
        long leftNoOneCount = getCount(max, leftCount);
        long leftOneCount = leftCount - leftNoOneCount;
        long rightNoOneCount = getCount(max, rightCount);
        long rightOneCount = rightCount - rightNoOneCount;
        
        return ((getSum(max, leftNoOneCount, leftOneCount) + getSum(max, rightNoOneCount, rightOneCount)) + max) <= maxSum;
    }

    public long getCount(long v, long count) {
        if (v - 2 <= 0) {
            return 0;
        }
        
        if ((v - 2) <= count) {
            return v - 2;
        }
        
        return count;
    }

    public long getSum(long max, long noOneCount, long oneCount) {
        return ((noOneCount) * ((max - 1) + (max - noOneCount))) / 2 + oneCount;
    }

    public int maxValue(int n, int index, int maxSum) {
        this.n = n;
        this.index = index;
        this.maxSum = maxSum;     
        
        long left = 1;
        long right = maxSum; 
        long ans = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int) ans; 
    }
}