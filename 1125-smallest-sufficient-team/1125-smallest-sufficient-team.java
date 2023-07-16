class Solution {
    
    class Bit {

        int bit;
        int index;

        Bit(int bit, int index) {
            this.bit = bit;
            this.index = index;
        }
       
        @Override
        public boolean equals(Object o) {
            Bit bit = (Bit) o;
            return this.bit == bit.bit && this.index == bit.index;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(bit, index);
        }

    }

    public Map<Bit, List<Integer>> m = new HashMap<>();
    public Map<String, Integer> convert = new HashMap<>();
    public List<List<String>> people;
    public int size;
    
    public List<Integer> dfs(int bit, int index) {
        if (bit == ((1 << size) - 1)) {
            return new ArrayList<>();
        }
        
        if (index == people.size()) {
            return null;
        }

        Bit bitObject = new Bit(bit, index);
        
        if (m.containsKey(bitObject)) {
            return m.get(bitObject);
        }
        
        int selectBit = bit;
        
        for (int i = 0; i < people.get(index).size(); i++) {
            selectBit |= (1 << convert.get(people.get(index).get(i)));
        }

        List<Integer> selectResult = dfs(selectBit, index + 1); // 얘에서 [3] 을 return 받음
        List<Integer> noSelectResult = dfs(bit, index + 1); // 얘에서도 [3] 을 return 받음
        
        if (selectResult != null) {
            selectResult = new ArrayList<>(selectResult);
            selectResult.add(index);
        }
        
        m.put(bitObject, judge(selectResult, noSelectResult));
        return m.get(bitObject);
    }

    public List<Integer> judge(List<Integer> select, List<Integer> noSelect) {
        if (select == null && noSelect == null) {
            return null;
        }

        if (select == null) {
            return noSelect;
        }

        if (noSelect == null) {
            return select;
        }

        if (select.size() < noSelect.size()) {
            return select;
        }
        
        return noSelect;
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        size = req_skills.length;
        this.people = people;
        
        for (int i = 0; i < req_skills.length; i++) {
            convert.put(req_skills[i], i);
        }
        
        dfs(0, 0);
        
        return m.get(new Bit(0, 0))
            .stream()
            .mapToInt(v -> v) 
            .toArray();
    }
    
}