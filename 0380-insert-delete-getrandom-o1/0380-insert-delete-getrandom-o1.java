import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> valuesToIndex;
    List<Integer> values;

    public RandomizedSet() {
        valuesToIndex = new HashMap<>();
        values = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        // insert 하면 containsKey 로 확인
        if (valuesToIndex.containsKey(val)) {
            return false;   
        }

        // valuesToIndex 에다가 list.size() - 1 을 넣어서 인덱싱해준다.
        values.add(val);
        valuesToIndex.put(val, values.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (valuesToIndex.containsKey(val)) {
            int indexOfValue = valuesToIndex.get(val); // value in list
            // 마지막 인덱스의 값을 indexOfValue 에다가 옮겨야함
            // 그리고 마지막 값을 indexOfValue 에다가 옮겨야 함
            // 그리고 list 에서 remove 연산을 해야함, 마지막 놈을        
            valuesToIndex.put(values.get(values.size() - 1), indexOfValue);
            values.set(indexOfValue, values.get(values.size() - 1));
            valuesToIndex.remove(val);
            values.remove(values.size() - 1);

            return true;
        }

        return false;
    }
    
    public int getRandom() {
        Random random = new Random();
        return values.get(random.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */