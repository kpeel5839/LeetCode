class Solution {

    public String bit(int a) {
        StringBuilder sb = new StringBuilder();

        while (a != 0) {
            sb.append(a % 2);
            a /= 2;
        }
        
        return sb.toString();
    }

    public int calculate(int a, int b) { 
        String aa = bit(a);
        String bb = bit(b);

        int result = 0;
        aa = aa + "0".repeat(Math.max(0, bb.length() - aa.length()));
        bb = bb + "0".repeat(Math.max(0, aa.length() - bb.length()));

        for (int i = 0; i < aa.length(); i++) {
            int aaa = aa.charAt(i) - '0';
            int bbb = bb.charAt(i) - '0';
            
            if (bbb == 1) {
                aaa = (aaa + 1) % 2;
            }

            result = result + aaa * (int) Math.pow(2, i);
        }

        return result;
    }

    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            ans[i] = calculate(pref[i - 1], pref[i]);
        }

        return ans;
    }
}