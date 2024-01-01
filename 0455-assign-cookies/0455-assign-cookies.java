class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int answer = 0;
        int index = 0;

        for (int i = 0; i < g.length; i++) {
            while (index != s.length && s[index] < g[i]) {
                index++;
            }

            if (index == s.length) {
                continue;
            }
            
            answer++;
            index++;
        }
     
        return answer;
    }
}