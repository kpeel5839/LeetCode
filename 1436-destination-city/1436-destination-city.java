class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> inner = new HashMap<>();
        Map<String, Integer> outgoing = new HashMap<>();
        for (List<String> s : paths) {
            inner.put(s.get(0), inner.getOrDefault(s.get(0), 0));
            inner.put(s.get(1), inner.getOrDefault(s.get(1), 0));
            
            outgoing.put(s.get(0), outgoing.getOrDefault(s.get(0), 0));
            outgoing.put(s.get(1), outgoing.getOrDefault(s.get(1), 0));
            
            outgoing.put(s.get(0), outgoing.get(s.get(0)) + 1);
            inner.put(s.get(1), inner.get(s.get(1)) + 1);
        }
        
        for (List<String> s : paths) {
            for (String ss : s) {
                if (inner.get(ss) == 1 && outgoing.get(ss) == 0) {
                    return ss;
                }
            }
        }
        
        return "";
    }
}