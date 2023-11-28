public class Solution {
    public int beautifulSubstrings(String s, int k) {
        Map<Integer, List<Integer>> grps = new HashMap<>();
        grps.put(0, new ArrayList<>());
        grps.get(0).add(0);

        String vowels = "aeiou";
        for (int i = 0, presum = 0; i < s.length(); i++) {
            presum += vowels.indexOf(s.charAt(i)) != -1 ? 1 : -1;
            grps.computeIfAbsent(presum, key -> new ArrayList<>()).add(i + 1);
        }

        int x;
        for (x = 1; x <= k && x * x % k != 0; x++);
        x *= 2;

        long ans = 0;
        for (Map.Entry<Integer, List<Integer>> entry : grps.entrySet()) {
            List<Integer> grp = entry.getValue();
            int[] mod = new int[x];
            for (int i : grp) {
                ans += mod[i % x]++;
            }
        }

        return (int) ans;
    }
}
