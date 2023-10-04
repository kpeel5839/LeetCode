class MyHashMap {

    public int[] bucket;

    public MyHashMap() {
        bucket = new int[1_000_001];
        Arrays.fill(bucket, -1);
    }
    
    public void put(int key, int value) {
        bucket[key] = value;
    }
    
    public int get(int key) {
        return bucket[key];
    }
    
    public void remove(int key) {
        bucket[key] = -1;
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */