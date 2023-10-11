class Solution {

    public List<Integer> list = new ArrayList<>();

    public int findLower(int target) {
       int l = 0;
       int r = list.size() - 1;
       int ans = -1;

       while (l <= r) { 
           int m = (l + r) / 2;

           if (target <= list.get(m)) { 
               r = m - 1;
               ans = m;
           } else {
               l = m + 1;
           }
       }

       return ans;
    }

    public int findUpper(int target) {
       int l = 0;
       int r = list.size() - 1;
       int ans = -1;

       while (l <= r) { 
           int m = (l + r) / 2;

           if (list.get(m) <= target) { 
               l = m + 1;
               ans = m;
           } else {
               r = m - 1;
           }
       }
       
       return ans;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < people.length; i++) {
            set.add(people[i]);
        }

        for (Integer value : set) {
            list.add(value);
        }

        Collections.sort(list);
        int[] add = new int[list.size()];
        int[] result = new int[list.size()];
        
        for (int i = 0; i < flowers.length; i++) {
            int left = findLower(flowers[i][0]);
            int right = findUpper(flowers[i][1]);
            
            if (left == -1 || right == -1) {
                continue;
            }
            
            if (right < left) {
                continue;
            }

            add[left]++;

            if (right != list.size() - 1) {
                add[right + 1]--;
            }
        }
        
        int addCount = 0;

        for (int i = 0; i < list.size(); i++) {
            addCount += add[i];
            m.put(list.get(i), addCount);
        }

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            ans[i] = m.get(people[i]);
        }

        return ans;
    }
}