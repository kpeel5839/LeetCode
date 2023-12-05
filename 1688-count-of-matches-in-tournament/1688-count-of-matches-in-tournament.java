class Solution {
    public int numberOfMatches(int n) {
        int answer = 0;
        
        while (n != 1) {
            answer += n / 2;
            n = (int) Math.ceil(n / 2d);
        }
        
        return answer;
    }
}