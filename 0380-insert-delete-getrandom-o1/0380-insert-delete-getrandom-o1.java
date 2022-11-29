import java.util.*;

class RandomizedSet {
    Set<Integer> values;

    public RandomizedSet() {
        values = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if (values.contains(val)) { // already exists
            return false;
        }

        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (values.contains(val)) {
            values.remove(val);
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        Random random = new Random();
        int extractIndex = random.nextInt(Math.min(5, values.size()));
        int randomNumber = 0;
        Iterator<Integer> it = values.iterator();
        
        for (int i = 0; i <= extractIndex; i++) {
            randomNumber = it.next();
        }

        return randomNumber;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */