class MyHashSet {
    public boolean[] v;

    public MyHashSet() {
        v = new boolean[(int) Math.pow(10, 6) + 1];
    }
    
    public void add(int key) {
        v[key] = true;
    }
    
    public void remove(int key) {
        v[key] = false;
    }
    
    public boolean contains(int key) {
        return v[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */