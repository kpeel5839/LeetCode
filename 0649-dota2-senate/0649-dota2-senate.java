class Solution {
    public int search(int v, List<Integer> ll) {
        int l = 0;
        int r = ll.size() - 1;
        int ans = 0;
        
        while (l <= r) {
            int m = (l + r) / 2;
            
            if (v < ll.get(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return ans;
    }
    
    public String predictPartyVictory(String s) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                l1.add(i);
                s1.add(i);
            } else {
                l2.add(i);
                s2.add(i);
            } 
        }    
        
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'R') {
                    if (!s1.contains(i)) {
                        continue;
                    }

                    if (s2.size() == 0) {
                        return "Radiant";
                    }

                    int n = search(i, l2);            
                    int index = l2.remove(n);
                    s2.remove(index);                
                } else {
                    if (!s2.contains(i)) {
                        continue;
                    }

                    if (s1.size() == 0) {
                        return "Dire";
                    }                    

                    int n = search(i, l1);
                    int index = l1.remove(n);
                    s1.remove(index);           
                }
            }
        }                   
    }
}