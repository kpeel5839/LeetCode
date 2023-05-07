class FrequencyTracker {
    
    public Map<Integer, Integer> m;
    public Map<Integer, Integer> mm;

    public FrequencyTracker() {
        m = new HashMap<>();
        mm = new HashMap<>();
    }
    
    public void add(int number) {
        m.put(number, m.getOrDefault(number, 0) + 1);                
        mm.put(m.get(number) - 1, mm.getOrDefault(m.get(number) - 1, 1) - 1);       
        mm.put(m.get(number), mm.getOrDefault(m.get(number), 0) + 1);
    }
    
    public void deleteOne(int number) {
        if (m.containsKey(number) && 0 < m.get(number)) {
            int a = m.get(number);
            m.put(number, a - 1);
            mm.put(a - 1, mm.get(a - 1) + 1);
            mm.put(a, mm.get(a) - 1);            
        }
    }
    
    public boolean hasFrequency(int frequency) {
        return mm.containsKey(frequency) && mm.get(frequency) != 0;                
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */