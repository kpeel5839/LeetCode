class Solution {

    public int ans;
    public int k;
    public char[] arr;

    public void sliding(char pivot) { // pivot
        int l = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != pivot) {
                count++;
            }
            
            while (l <= i && k < count) {
                if (arr[l++] != pivot) {
                    count--;
                }
            }

            ans = Math.max(ans, i - l + 1);
        }
    }
    
    public int maxConsecutiveAnswers(String answerKey, int k) {
        arr = answerKey.toCharArray(); 
        this.k = k;
        sliding('T');
        sliding('F');
        return ans; 
    }
}