class Solution {
    
    public String word;
    public int k;
    public int n;
    
    public int solution() {
        int[][] prefixSum = new int[26][n + 1];

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            
            for (int j = 0; j < 26; j++) {
                prefixSum[j][i + 1] = prefixSum[j][i] + (c - 'a' == j ? 1 : 0);
            }
        }
        
        int[] count = new int[26];
        int[] add = new int[n + 1];
        int left = 1;
        int answer = 0;
        int cutIndex = 0;
       
        for (int i = 1; i <= n; i++) {
            char c = word.charAt(i - 1);
            
            if (i != 1 && 2 < Math.abs(c - word.charAt(i - 2))) {
                left = i;
                cutIndex = i;
                Arrays.fill(count, 0);
            }

            count[c - 'a']++;

            while (left != i && k < count[c - 'a']) {
                count[word.charAt(left - 1) - 'a']--;
                left++;
            }

            if (count[c - 'a'] == k) {
                answer += correct(i, prefixSum, add, cutIndex);
            }
        }

        return answer;
    }
    
    public int correct(int index, int[][] prefixSum, int[] add, int cutIndex) {
        int result = 0;

        Loop:
        for (int i = 26; 1 <= i; i--) {
            int previousIndex = index - k * i + 1;

            if (previousIndex < 1 || !(cutIndex <= previousIndex)) {
                continue;
            }

            for (int j = 0; j < 26; j++) {
                int alphabetCount = prefixSum[j][index] - prefixSum[j][previousIndex - 1];
                if (!(alphabetCount == k || alphabetCount == 0)) {
                    continue Loop;
                }
            }

            if (result == 0) {
                result = add[previousIndex] + 1;
            } 
        
            add[previousIndex]++;
        }

        return result;
    }
    
    public int countCompleteSubstrings(String word, int k) {
        this.word = word;
        this.k = k;
        this.n = word.length();
        return solution();
    }
    
}