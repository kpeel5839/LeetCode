public class Solution {
    public int beautifulSubstrings(String s, int k) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        Set<Character> set = new HashSet<>(Set.of('a', 'i', 'e', 'o', 'u'));
        int sum = 0;
        m.put(0, new ArrayList<>());
        m.get(0).add(0);

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                sum++;
            } else {
                sum--;
            }
            
            m.computeIfAbsent(sum, ignored -> new ArrayList<>()).add(i + 1);
        }

        int newK = 0;
        for (int i = 1; i <= k; i++) {
            if ((i * i) % k == 0) {
                newK = i * 2;
                break;
            }
        }

        int ans = 0;
        for (List<Integer> list : m.values()) {
            int[] mod = new int[newK];
            for (int value : list) {
                ans += mod[value % newK]++;
            }
        }

        return ans;
    }
}
