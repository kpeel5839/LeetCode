class Solution {

    public int n;
    public int k;

    public int recursive(int now, int left, int right) {
        if (left == right) {
            return now;
        }

        int mid = (left + right) / 2;

        if (k <= mid) {  
            return recursive(now, left, mid);
        } else { 
            return recursive((now + 1) % 2, mid + 1, right);
        }
    }

    public int kthGrammar(int n, int k) {
        this.n = n;
        this.k = k;
        return recursive(0, 1, (int) Math.pow(2, n - 1));
    }
    
}