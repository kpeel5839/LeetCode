class Solution {
    public List<Integer> addToArrayForm(int[] num1, int k) {
        String kToString = Integer.toString(k);
        int[] num2 = new int[kToString.length()];
        for (int i = 0; i < kToString.length(); i++) {
            num2[i] = kToString.charAt(i) - '0';
        }
        
        if (num1.length < num2.length) {
            int[] tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        
        List<Integer> answer = new ArrayList<>();
        int round = 0;
        int radix = 10;
        int index1 = num1.length - 1;
        int index2 = num2.length - 1;
        
        while (index2 != -1) {
            answer.add((num1[index1] + num2[index2] + round) % radix);
            round = (num1[index1] + num2[index2] + round) / radix;
            index1--;
            index2--;
        }
        
        while (index1 != -1) {
            answer.add((num1[index1] + round) % radix);
            round = (num1[index1] + round) / radix;
            index1--;
        }
        
        if (round != 0) {
            answer.add(round);
        }
        
        Collections.reverse(answer);
        
        return answer;
    }
}