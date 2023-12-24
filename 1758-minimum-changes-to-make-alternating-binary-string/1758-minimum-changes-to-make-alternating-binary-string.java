class Solution {

    public String s;

    public int cal(int submit) {
        int answer = 0;

        for (int i = 1; i < s.length(); i++) {
            int number = s.charAt(i) - '0';
            
            if (submit == number) {
                submit = (number + 1) % 2;
                answer++;
                continue;
            }
            
            submit = number;
        } 

        return answer;
    }
   
    public int minOperations(String s) {
        this.s = s;
        int submit = s.charAt(0) - '0';
        
        return Math.min(cal(submit), cal((submit + 1) % 2) + 1);
    }

}