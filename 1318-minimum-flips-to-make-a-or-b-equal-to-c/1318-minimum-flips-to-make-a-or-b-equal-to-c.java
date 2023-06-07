class Solution {

    public int judge(int bit, int compare) {
        return (bit & compare) != 0 ? 1 : 0; // 즉 현재 자리수가 1인 것임 
    }
    
    public int minFlips(int a, int b, int c) {
        int ans = 0;

        for (int i = 1; i <= (int) Math.pow(10, 9); i <<= 1) {
            int count = judge(a, i) + judge(b, i);

            if (judge(c, i) == 1) { // one
                if (count == 0) {
                    ans++;        
                }
            } else { // zero
                ans += count;
            }
        }
        
        return ans;
    }
}